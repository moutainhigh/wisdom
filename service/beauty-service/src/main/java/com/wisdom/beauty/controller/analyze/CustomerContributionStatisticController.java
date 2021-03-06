package com.wisdom.beauty.controller.analyze;

import com.wisdom.beauty.api.responseDto.ExpenditureAndIncomeResponseDTO;
import com.wisdom.beauty.api.responseDto.UserConsumeRequestDTO;
import com.wisdom.beauty.core.redis.RedisUtils;
import com.wisdom.beauty.core.service.ShopStatisticsAnalysisService;
import com.wisdom.beauty.interceptor.LoginAnnotations;
import com.wisdom.beauty.interceptor.LoginRequired;
import com.wisdom.beauty.util.UserUtils;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.beauty.CustomerContributionDTO;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.user.SysBossDTO;
import com.wisdom.common.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@LoginAnnotations
@RequestMapping(value = "analyze")
public class CustomerContributionStatisticController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShopStatisticsAnalysisService shopStatisticsAnalysisService;
    @Autowired
    private RedisUtils redisUtils;

    //获取门店某天的业绩
    @RequestMapping(value = "shopCustomerContributionByDate", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<CustomerContributionDTO>> shopCustomerContributionByDate(@RequestParam String shopId, @RequestParam String date) {

        ResponseDTO<List<CustomerContributionDTO>> responseDTO = new ResponseDTO<>();

        return responseDTO;
    }

    /**
     * @Author:zhanghuan
     * @Param:  desc 降序   asc升序
     * @Return:
     * @Description:
     * @Date:2018/5/15 14:12
     */
    @RequestMapping(value = "/getClerkAchievementList", method = RequestMethod.GET)
    @ResponseBody
    ResponseDTO<List<ExpenditureAndIncomeResponseDTO>> getClerkAchievementList(
                                                                               @RequestParam String startTime,
                                                                               @RequestParam String endTime,
                                                                               @RequestParam(required = false)  String sortBy,
                                                                               @RequestParam(required = false)  String sortRule) {
        SysBossDTO bossInfo = UserUtils.getBossInfo();
        PageParamVoDTO<UserConsumeRequestDTO> pageParamVoDTO = new PageParamVoDTO<>();
        UserConsumeRequestDTO userConsumeRequestDTO = new UserConsumeRequestDTO();
        String sysShopId = redisUtils.getShopId();
        if (StringUtils.isNotBlank(sysShopId)) {
            userConsumeRequestDTO.setSysShopId(sysShopId);
        }
        userConsumeRequestDTO.setSysBossCode(bossInfo.getSysBossCode());
        pageParamVoDTO.setRequestData(userConsumeRequestDTO);
        pageParamVoDTO.setStartTime(startTime);
        pageParamVoDTO.setEndTime(endTime);
        List<ExpenditureAndIncomeResponseDTO> list = shopStatisticsAnalysisService.getClerkAchievementList(pageParamVoDTO);
        if(CollectionUtils.isNotEmpty(list)){
            Collections.sort(list, new Comparator<ExpenditureAndIncomeResponseDTO>() {
                @Override
                public int compare(ExpenditureAndIncomeResponseDTO o1, ExpenditureAndIncomeResponseDTO o2) {
                    if("asc".equals(sortRule)){
                        if("expenditure".equals(sortBy)){
                            BigDecimal i = o1.getExpenditure().subtract(o2.getExpenditure());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("income".equals(sortBy)){
                            BigDecimal i = o1.getIncome().subtract(o2.getIncome());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("kahao".equals(sortBy)){
                            BigDecimal i = o1.getKahao().subtract(o2.getKahao());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("consumeTime".equals(sortBy)){
                            Integer i = o1.getConsumeTime()-(o2.getConsumeTime());
                            return i;
                        }
                        if("serviceNumber".equals(sortBy)){
                            Integer i = o1.getServiceNumber()-(o2.getServiceNumber());
                            return i;
                        }

                    }else {
                        if("expenditure".equals(sortBy)){
                            BigDecimal i = o2.getExpenditure().subtract(o1.getExpenditure());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("income".equals(sortBy)){
                            BigDecimal i = o2.getIncome().subtract(o1.getIncome());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("kahao".equals(sortBy)){
                            BigDecimal i = o2.getKahao().subtract(o1.getKahao());
                            return i.setScale(0,BigDecimal.ROUND_UP).intValue();
                        }
                        if("consumeTime".equals(sortBy)){
                            Integer i = o2.getConsumeTime()-(o1.getConsumeTime());
                            return i;
                        }
                        if("serviceNumber".equals(sortBy)){
                            Integer i = o2.getServiceNumber()-(o1.getServiceNumber());
                            return i;
                        }
                    }
                    return 0;
                }
            });
        }

        ResponseDTO<List<ExpenditureAndIncomeResponseDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(list);
        return responseDTO;
    }
}
