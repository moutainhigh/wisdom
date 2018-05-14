package com.wisdom.beauty.controller.archives;


import com.wisdom.beauty.api.dto.ShopAppointServiceDTO;
import com.wisdom.beauty.api.dto.ShopUserArchivesDTO;
import com.wisdom.beauty.api.extDto.ExtShopAppointServiceDTO;
import com.wisdom.beauty.core.service.ShopAppointmentService;
import com.wisdom.beauty.core.service.ShopCustomerArchivesService;
import com.wisdom.beauty.util.UserUtils;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.user.SysBossDTO;
import com.wisdom.common.util.CommonUtils;
import com.wisdom.common.util.PinYinSort;
import com.wisdom.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ArchivesController
 *
 * @Author： huan
 * @Description: 档案控制层
 * @Date:Created in 2018/4/4 9:26
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "earlyWarning")
public class ArchivesEarlyWarningController {

    @Autowired
    private ShopCustomerArchivesService shopCustomerArchivesService;

    @Autowired
    private ShopAppointmentService shopAppointmentService;


    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 档案预警接口
     * @param queryType 一个月未到店 one ;三个月未到店 three ;六个月未到店 six
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getEarlyWarningList", method = RequestMethod.GET)
    @ResponseBody
    ResponseDTO<Object> getEarlyWarningList(@RequestParam String queryType, @RequestParam(required = false) String pageNo, @RequestParam(required = false) String pageSize) {

        logger.info("档案预警接口传入参数={}", "queryType = [" + queryType + "], pageNo = [" + pageNo + "], pageSize = [" + pageSize + "]");
        ResponseDTO<Object> responseDTO = new ResponseDTO<>();
        SysBossDTO bossInfo = UserUtils.getBossInfo();
        if (null == bossInfo) {
            logger.error("获取到的boss信息为空");
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("获取的boss信息为空！");
            return responseDTO;
        }
        String bossInfoId = bossInfo.getId();

        //获取当前boss下的档案列表
        ShopUserArchivesDTO shopUserArchivesDTO = new ShopUserArchivesDTO();
        shopUserArchivesDTO.setSysBossId(bossInfoId);
        List<ShopUserArchivesDTO> shopUserArchivesInfo = shopCustomerArchivesService.getShopUserArchivesInfo(shopUserArchivesDTO);
        if (CommonUtils.objectIsEmpty(shopUserArchivesDTO)) {
            logger.info("获取当前boss下的档案列表为空");
            return getSuccessResponseDTO(responseDTO, shopUserArchivesInfo);
        }

        //根据queryType构造查询时间段
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        if ("one".equals(queryType)) {
            calendar.add(Calendar.MONTH, -1);
        } else if ("three".equals(queryType)) {
            calendar.add(Calendar.MONTH, -3);
        } else if ("six".equals(queryType)) {
            calendar.add(Calendar.MONTH, -6);
        }

        //根据查询时间段查询预约列表
        ExtShopAppointServiceDTO extShopAppointServiceDTO = new ExtShopAppointServiceDTO();
        extShopAppointServiceDTO.setSearchStartTime(calendar.getTime());
        extShopAppointServiceDTO.setSearchEndTime(currentDate);
        extShopAppointServiceDTO.setSysBossId(bossInfoId);
        List<ShopAppointServiceDTO> appointClerkInfoByCriteria = shopAppointmentService.getShopAppointClerkInfoByCriteria(extShopAppointServiceDTO);
        if (CommonUtils.objectIsEmpty(appointClerkInfoByCriteria)) {
            logger.info("获取当前boss下的预约列表为空");
            return getSuccessResponseDTO(responseDTO, shopUserArchivesInfo);
        }

        //遍历档案列表将在预约列表的用户remove掉
        Iterator<ShopUserArchivesDTO> iterator = shopUserArchivesInfo.iterator();
        while (iterator.hasNext()) {
            ShopUserArchivesDTO archivesDTO = iterator.next();
            for (ShopAppointServiceDTO serviceDTO : appointClerkInfoByCriteria) {
                if (StringUtils.isNotBlank(archivesDTO.getSysUserId()) && StringUtils.isNotBlank(serviceDTO.getSysUserId())
                        && archivesDTO.getSysUserId().equals(serviceDTO.getSysUserId())) {
                    iterator.remove();
                }
                archivesDTO.setUpdateDate(serviceDTO.getAppointStartTime());
            }
        }

        ArrayList<Object> lastList = new ArrayList<>();
        for (char a : PinYinSort.getSortType()) {
            HashMap<Object, Object> hashMap = new HashMap<>(16);
            ArrayList<Object> arrayList = new ArrayList<>();
            for (ShopUserArchivesDTO archivesDTO : shopUserArchivesInfo) {
                String pinyin = null;
                String rule = "[\\u4e00-\\u9fa5]+";
                Pattern pattern = Pattern.compile(rule);
                Matcher m = pattern.matcher(archivesDTO.getSysUserName());
                if (m.find() && m.group(0).equals(archivesDTO.getSysUserName())) {
                    pinyin = PinYinSort.ToPinYinString(archivesDTO.getSysUserName());
                } else {
                    pinyin = archivesDTO.getSysUserName();
                }
                if (StringUtils.isNotBlank(pinyin) && a == pinyin.charAt(0)) {
                    arrayList.add(archivesDTO);
                }
            }
            if (arrayList.size() > 0) {
                hashMap.put(String.valueOf(a).toUpperCase(), arrayList);
                lastList.add(hashMap);
            }
        }

        //查询个数
        Map<String, Object> map = new HashMap<>(16);
        map.put("info", lastList);

        //返回过滤后的档案列表
        responseDTO.setResponseData(map);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 获取成功的返回结果
     *
     * @param responseDTO
     * @param shopUserArchivesInfo
     * @return
     */
    private ResponseDTO<Object> getSuccessResponseDTO(ResponseDTO<Object> responseDTO, List<ShopUserArchivesDTO> shopUserArchivesInfo) {
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(shopUserArchivesInfo);
        responseDTO.setErrorInfo("获取的boss信息为空！");
        return responseDTO;
    }


}
