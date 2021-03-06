package com.wisdom.beauty.controller.clerk;


import com.wisdom.beauty.api.requestDto.ShopClerkWorkRecordRequestDTO;
import com.wisdom.beauty.api.responseDto.ShopClerkWorkRecordResponseDTO;
import com.wisdom.beauty.core.service.ShopClerkWorkService;
import com.wisdom.beauty.interceptor.LoginAnnotations;
import com.wisdom.beauty.util.UserUtils;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.user.SysClerkDTO;
import com.wisdom.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanghuan on 2018/5/31.
 * <p>
 * 员工工作业绩相关控制层
 */
@Controller
@LoginAnnotations
@RequestMapping(value = "clerkWork")
public class ClerkWorkRecordController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShopClerkWorkService shopClerkWorkService;

    /**
     * @Author:zhanghuan
     * @Param:
     * @Return:
     * @Description: 获取具体某个店员的业绩和耗卡（包含来源分析）
     *               (可以用于在boss端调用,需要前端传递sysClerkId)
     * @Date:2018/5/31 15:32
     */
    @RequestMapping(value = "/getClerkWorkDetail", method = {RequestMethod.GET})
    @ResponseBody
    ResponseDTO<Map<String, String>> getClerkWorkDetail(@RequestParam(required = false) String sysClerkId,
                                                        @RequestParam String startTime,
                                                        @RequestParam String endTime) {
        String clerkId=null;
        SysClerkDTO sysClerkDTO = UserUtils.getClerkInfo();
        if (sysClerkDTO != null) {
            clerkId=sysClerkDTO.getId();
        }else {
            if(StringUtils.isNotBlank(sysClerkId)){
                clerkId=sysClerkId;
            }
        }
        if(clerkId==null){
            logger.info("clerkId参数为空");
            return  null;
        }
        PageParamVoDTO<ShopClerkWorkRecordRequestDTO> pageParamVoDTO = new PageParamVoDTO<>();
        pageParamVoDTO.setStartTime(startTime);
        pageParamVoDTO.setEndTime(endTime);
        ShopClerkWorkRecordRequestDTO shopClerkWorkRecordRequestDTO = new ShopClerkWorkRecordRequestDTO();
        shopClerkWorkRecordRequestDTO.setSysClerkId(clerkId);

        pageParamVoDTO.setRequestData(shopClerkWorkRecordRequestDTO);

        Map<String, String> map = shopClerkWorkService.getShopConsumeAndRecharge(pageParamVoDTO);
        if (map != null) {
            BigDecimal income = new BigDecimal(map.get("consume")).add(new BigDecimal(map.get("recharge")));
            BigDecimal expenditure = new BigDecimal(map.get("oneConsume")).add(new BigDecimal(map.get("scratchCard")));
            BigDecimal kahao = new BigDecimal(map.get("cardConsume"));

            map.put("income", income.toString());
            map.put("expenditure", expenditure.toString());
            map.put("kahao", kahao.toString());
        }
        else
        {
            map = new HashMap<>(16);
            map.put("income", "0");
            map.put("expenditure", "0");
            map.put("kahao", "0");
        }

        ResponseDTO<Map<String, String>> response = new ResponseDTO<>();
        response.setResponseData(map);
        response.setResult(StatusConstant.SUCCESS);
        return response;
    }

    /**
     * @Author:zhanghuan
     * @Param:   searchFile 1   查业绩明细
     *           searchFile 2   耗卡明细
     *           searchFile 3  卡耗明细
     * @Return:
     * @Description: 获取员工的业绩,耗卡,卡耗明细(可以用于在boss端调用,需要前端传递sysClerkId)
     *                  业绩明细: consumeType 0 goodsType 2
     *                         : consumeType 0 goodsType 0 1 3 4
     *                  耗卡明细:consumeType 1 goodsType 1
     *                          consumeType 1 goodsType 3
     *                          consumeType 0 goodsType 0
         *                  卡耗明细:consumeType 1 goodsType2
     * @Date:2018/5/31 15:32
     */
    @RequestMapping(value = "/getClerkPerformanceList", method = RequestMethod.GET)
    @ResponseBody
    ResponseDTO<List<ShopClerkWorkRecordResponseDTO>> getClerkPerformanceList(@RequestParam String startTime,
                                                                              @RequestParam String endTime,
                                                                              @RequestParam(required = false) String sysClerkId,
                                                                              @RequestParam String searchFile,
                                                                              int pageSize) {
        String clerkId=null;
        SysClerkDTO sysClerkDTO = UserUtils.getClerkInfo();
        if (sysClerkDTO != null) {
            clerkId=sysClerkDTO.getId();
        }else {
            if(StringUtils.isNotBlank(sysClerkId)){
                clerkId=sysClerkId;
            }
        }
        if(clerkId==null){
            logger.info("clerkId参数为空");
            return  null;
        }
        ShopClerkWorkRecordRequestDTO shopClerkWorkRecordRequestDTO = new ShopClerkWorkRecordRequestDTO();
        shopClerkWorkRecordRequestDTO.setSysClerkId(clerkId);
        //设置为true 这样需要通过consumeType和goodType做为条件来查询
        shopClerkWorkRecordRequestDTO.setSearchFile(searchFile);

        PageParamVoDTO<ShopClerkWorkRecordRequestDTO> pageParamVoDTO = new PageParamVoDTO<>();
        pageParamVoDTO.setRequestData(shopClerkWorkRecordRequestDTO);
        pageParamVoDTO.setPaging(true);
        pageParamVoDTO.setPageNo(0);
        pageParamVoDTO.setPageSize(pageSize);

        pageParamVoDTO.setStartTime(startTime);
        pageParamVoDTO.setEndTime(endTime);
        List<ShopClerkWorkRecordResponseDTO> shopClerkWorkRecordResponseDTOs = shopClerkWorkService
                .getShopCustomerConsumeRecordList(pageParamVoDTO);

        ResponseDTO<List<ShopClerkWorkRecordResponseDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(shopClerkWorkRecordResponseDTOs);
        return responseDTO;
    }
}
