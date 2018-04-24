package com.wisdom.business.service.account;

import com.aliyun.oss.ServiceException;
import com.wisdom.business.client.UserServiceClient;
import com.wisdom.business.mapper.account.IncomeMapper;
import com.wisdom.business.mapper.account.IncomeRecordManagementMapper;
import com.wisdom.business.service.transaction.PayRecordService;
import com.wisdom.common.dto.account.IncomeRecordDTO;
import com.wisdom.common.dto.account.IncomeRecordManagementDTO;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.account.PayRecordDTO;
import com.wisdom.common.dto.system.ExportIncomeRecordExcelDTO;
import com.wisdom.common.dto.system.PageParamDTO;
import com.wisdom.common.dto.transaction.BusinessOrderDTO;
import com.wisdom.common.dto.transaction.MonthTransactionRecordDTO;
import com.wisdom.common.dto.user.UserInfoDTO;
import com.wisdom.common.persistence.Page;
import com.wisdom.common.util.CommonUtils;
import com.wisdom.common.util.DateUtils;
import com.wisdom.common.util.FrontUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/6/26.
 */

@Service
@Transactional(readOnly = false)
public class IncomeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private IncomeRecordManagementMapper incomeRecordManagementMapper;

    public List<IncomeRecordDTO> getUserIncomeInfoByDate(String userId, Date date) {
        List<IncomeRecordDTO> incomeRecordDTOS = incomeMapper.getUserIncomeInfoByDate(userId,date);
        return incomeRecordDTOS;
    }

    public void insertUserIncomeInfo(IncomeRecordDTO incomeRecordDTO) {
        incomeMapper.insertUserIncomeInfo(incomeRecordDTO);
    }

    public void updateIncomeInfo(IncomeRecordDTO incomeRecordDTO) {
        incomeMapper.updateIncomeInfo(incomeRecordDTO);
    }

    public List<IncomeRecordDTO> getUserIncomeRecordInfo(IncomeRecordDTO incomeRecordDTO) {
        return  incomeMapper.getUserIncomeInfo(incomeRecordDTO);
    }

    public PageParamDTO<List<IncomeRecordDTO>> queryUserIncomeByParameters(String phoneAndIdentify, String incomeType,
                                                                           String applyStartTime, String applyEndTime,String isExportExcel, Integer pageNo, Integer pageSize) {
        PageParamDTO<List<IncomeRecordDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = incomeMapper.queryUserIncomeCountByParameters(
                phoneAndIdentify,incomeType,applyStartTime,applyEndTime);
        page.setTotalCount(count);
        List<IncomeRecordDTO> commissionDTOList = incomeMapper.queryUserIncomeByParameters(phoneAndIdentify,incomeType,applyStartTime,applyEndTime,isExportExcel,pageStartNo,pageSize);

        for(IncomeRecordDTO incomeRecordDTO : commissionDTOList){
            incomeRecordDTO.setNickName(CommonUtils.nameDecoder(incomeRecordDTO.getNickName()));
        }
        page.setResponseData(commissionDTOList);

        return page;
    }

    public PageParamDTO<List<IncomeRecordDTO>> queryAllUserIncome(PageParamDTO pageParamDTO) {
        PageParamDTO<List<IncomeRecordDTO>> pageResult = new  PageParamDTO<>();
        String currentPage = String.valueOf(pageParamDTO.getPageNo());
        String pageSize = String.valueOf(pageParamDTO.getPageSize());
        Page<IncomeRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);
        Page<IncomeRecordDTO> resultPage = incomeMapper.queryAllUserIncome(page);
        pageResult.setTotalCount((int)resultPage.getCount());
        pageResult.setResponseData(resultPage.getList());
        return pageResult;
    }

    public List<IncomeRecordDTO> getUserIncomeRecordInfoByPage(String userId, PageParamDTO pageParamDTO) {
        return incomeMapper.getUserIncomeRecordInfoByPage(userId,pageParamDTO.getPageNo(),pageParamDTO.getPageSize());
    }

    public IncomeRecordDTO getIncomeRecordDetail(String transactionId) {
        return incomeMapper.getIncomeRecordDetail(transactionId);
    }

    public PageParamDTO<List<PayRecordDTO>> queryInstanceInfoByTransactionId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<PayRecordDTO>> page = new  PageParamDTO<>();
        List<PayRecordDTO> payRecordDTOList = incomeMapper.queryInstanceInfoByTransactionId(pageParamVoDTO);
        for(PayRecordDTO payRecordDTO : payRecordDTOList){
            try {
                payRecordDTO.setNickName(URLDecoder.decode(payRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(payRecordDTOList);
        return page;
    }

    public PageParamDTO<List<MonthTransactionRecordDTO>> queryMonthTransactionRecordByIncomeRecord(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<MonthTransactionRecordDTO>> pageResult = new  PageParamDTO<>();
        Date date = DateUtils.StrToDate(pageParamVoDTO.getEndTime(),"date");//string转Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 26);//设定日期为26号
        pageParamVoDTO.setEndTime(null);//设定当前时间
        calendar.add(Calendar.MONTH,-1);//当前月份减一
        calendar.set(Calendar.DAY_OF_MONTH, 25);//设定日期为25号

        pageParamVoDTO.setStartTime(null);
        String currentPage = String.valueOf(pageParamVoDTO.getPageNo());
        String pageSize = String.valueOf(pageParamVoDTO.getPageSize());
        Page<MonthTransactionRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);
        int count = incomeMapper.queryMonthTransactionRecordByIncomeRecordCount(pageParamVoDTO);
        List<MonthTransactionRecordDTO> pageData = incomeMapper.queryMonthRecordByParentRelation(pageParamVoDTO);
        for(MonthTransactionRecordDTO monthTransactionRecordDTO : pageData){
            try {
                List<PayRecordDTO> payRecordDTOS = payRecordService.queryUserInfoByTransactionId(monthTransactionRecordDTO.getTransactionId());
                if(payRecordDTOS.size()>0){
                    PayRecordDTO payRecordDTO = payRecordDTOS.get(0);
                    monthTransactionRecordDTO.setUserId(payRecordDTO.getSysUserId());
                    monthTransactionRecordDTO.setNickName(payRecordDTO.getNickName());
                    monthTransactionRecordDTO.setUserType(payRecordDTO.getUserType());
                    monthTransactionRecordDTO.setMobile(payRecordDTO.getMobile());
                    monthTransactionRecordDTO.setIdentifyNumber(payRecordDTO.getIdentifyNumber());
                }
                monthTransactionRecordDTO.setNickName(URLDecoder.decode(monthTransactionRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        pageResult.setTotalCount(count);
        pageResult.setResponseData(pageData);
        return pageResult;
    }

    public PageParamDTO<List<PayRecordDTO>> queryMonthPayRecordByUserId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        PageParamDTO<List<PayRecordDTO>> pageResult = new  PageParamDTO<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = DateUtils.StrToDate(pageParamVoDTO.getEndTime(),"date");//string转Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 26);//设定日期为26号
        pageParamVoDTO.setEndTime(null);//设定当前时间
        calendar.add(Calendar.MONTH,-1);//当前月份减一
        calendar.set(Calendar.DAY_OF_MONTH, 25);//设定日期为25号
        pageParamVoDTO.setStartTime(null);

        String currentPage = String.valueOf(pageParamVoDTO.getPageNo());
        String pageSize = String.valueOf(pageParamVoDTO.getPageSize());
        Page<PayRecordDTO> page = FrontUtils.generatorPage(currentPage, pageSize);
        int count = incomeMapper.queryMonthPayRecordCountByUserId(pageParamVoDTO);
        List<PayRecordDTO> pageData = incomeMapper.queryMonthPayRecordByUserId(pageParamVoDTO);
        for(PayRecordDTO payRecordDTO : pageData){
            try {
                payRecordDTO.setNickName(URLDecoder.decode(payRecordDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        pageResult.setTotalCount(count);
        pageResult.setResponseData(pageData);
        return pageResult;
    }

    public void updateIncomeRecord(IncomeRecordDTO incomeRecordDTO) {
        incomeMapper.updateIncomeRecord(incomeRecordDTO);
    }

    //查询即时奖励总额(个人)
    public String selectIncomeInstanceByUserId(String userId) {
        return incomeMapper.selectIncomeInstanceByUserId(userId);
    }

    public List<IncomeRecordManagementDTO> getIncomeRecordManagement(IncomeRecordManagementDTO incomeRecordManagementDTO) {
        return incomeRecordManagementMapper.getIncomeRecordManagement(incomeRecordManagementDTO);
    }

    public List<IncomeRecordDTO> getIncomeRecordByPageParam(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {

        String orderStatus ="2";
        String orderId ="";
        String orderAmount ="0";

        String CheckStatus =pageParamVoDTO.getRequestData().getCheckStatus();
        List<IncomeRecordDTO> incomeRecordDTOS = new ArrayList<>();
        if (StringUtils.isNotBlank(CheckStatus)) {
            incomeRecordDTOS = incomeMapper.getIncomeRecordByIncomeManagement(pageParamVoDTO);
        }else {
            incomeRecordDTOS =incomeMapper.getIncomeRecordByPageParam(pageParamVoDTO);
        }
        if(incomeRecordDTOS.size()==0){
            logger.info("佣金奖励条件查询 查出数据incomeRecordDTOS为0","审核状态"+CheckStatus );
            return incomeRecordDTOS;
        }
        IncomeRecordManagementDTO incomeRecordManagementDTO =new IncomeRecordManagementDTO();
        for (IncomeRecordDTO incomeRecordDTO : incomeRecordDTOS) {
            try {
                //查詢审核信息
                incomeRecordManagementDTO.setIncomeRecordId(incomeRecordDTO.getId());
                List<IncomeRecordManagementDTO> incomeRecordManagementDTOS = incomeRecordManagementMapper.getIncomeRecordManagement(incomeRecordManagementDTO);
                //一条数据,这说明有一方已审核,
                if(incomeRecordManagementDTOS.size()>0 && incomeRecordManagementDTOS.size() ==1) {
                    //运营人员审核
                    if("operation-1".equals(incomeRecordManagementDTOS.get(0).getUserType())){
                        incomeRecordDTO.setSecondCheckStatus("1");
                        incomeRecordDTO.setCheckUserType(incomeRecordManagementDTOS.get(0).getUserType());
                        incomeRecordDTO.setCheckStatus(incomeRecordManagementDTOS.get(0).getStatus());
                        incomeRecordDTO.setCheckUserName(URLDecoder.decode(incomeRecordManagementDTOS.get(0).getUserName(),"utf-8"));
                        incomeRecordDTO.setCheckSysUserId(incomeRecordManagementDTOS.get(0).getSysUserId());
                        incomeRecordDTO.setCreateDate(incomeRecordManagementDTOS.get(0).getCreateDate());
                    }else if("finance-1".equals(incomeRecordManagementDTOS.get(0).getUserType())){
                        //财务人员审核
                        incomeRecordDTO.setSecondCheckStatus("2");
                        incomeRecordDTO.setCheckUserType(incomeRecordManagementDTOS.get(0).getUserType());
                        incomeRecordDTO.setCheckStatus(incomeRecordManagementDTOS.get(0).getStatus());
                        incomeRecordDTO.setCheckUserName(URLDecoder.decode(incomeRecordManagementDTOS.get(0).getUserName(),"utf-8"));
                        incomeRecordDTO.setCheckSysUserId(incomeRecordManagementDTOS.get(0).getSysUserId());
                        incomeRecordDTO.setCreateDate(incomeRecordManagementDTOS.get(0).getCreateDate());
                    }
                }else if(incomeRecordManagementDTOS.size() == 2){
                    boolean status = true;
                    for (IncomeRecordManagementDTO incomeRecordManagementDTO1: incomeRecordManagementDTOS){
                        //说明有一方拒绝,插入3标记和拒绝标记以及拒绝人的信息
                        if("0".equals(incomeRecordManagementDTO1.getStatus())){
                            incomeRecordDTO.setSecondCheckStatus("3");
                            status = false;
                            incomeRecordDTO.setCheckUserType(incomeRecordManagementDTO1.getUserType());
                            incomeRecordDTO.setCheckStatus(incomeRecordManagementDTO1.getStatus());
                            incomeRecordDTO.setCheckUserName(URLDecoder.decode(incomeRecordManagementDTO1.getUserName(),"utf-8"));
                            incomeRecordDTO.setCheckSysUserId(incomeRecordManagementDTO1.getSysUserId());
                            incomeRecordDTO.setCreateDate(incomeRecordManagementDTO1.getCreateDate());
                        }
                    }
                    //经过双方审核,已通过
                    if(status){
                        incomeRecordDTO.setSecondCheckStatus("4");//记录双方通过标记
                        incomeRecordDTO.setCheckStatus("1");//记录审核状态为通过
                    }
                }else {
                    //没有数据,则说明没有被审核,标记为未审核
                    incomeRecordDTO.setSecondCheckStatus("0");
                }
                if(!"".equals(incomeRecordDTO.getNickName()) && incomeRecordDTO.getNickName() != null){
                    incomeRecordDTO.setNickName(URLDecoder.decode(incomeRecordDTO.getNickName(),"utf-8"));
                }
                if(!"".equals(incomeRecordDTO.getNextUserNickName()) && incomeRecordDTO.getNextUserNickName() != null){
                    incomeRecordDTO.setNextUserNickName(URLDecoder.decode(incomeRecordDTO.getNextUserNickName(),"utf-8"));
                }
            } catch (UnsupportedEncodingException e) {
                logger.info("service -- 根据条件查询佣金奖励getIncomeRecordByPageParam方法转换nickName失败" );
                e.printStackTrace();
                throw new ServiceException("转换nickName失败");
            }
            if (StringUtils.isBlank(incomeRecordDTO.getTransactionId())) {
                throw new ServiceException("incomeRecordDTO里TransactionId为空");
            }
            List<BusinessOrderDTO> businessOrderDTOS = payRecordService.queryOrderInfoByTransactionId(incomeRecordDTO.getTransactionId());
            //判断是否有数据
            if(businessOrderDTOS.size() != 0){
                //判断是否只有一笔订单
                if(businessOrderDTOS.size() > 1){
                    for (BusinessOrderDTO businessOrderDTO : businessOrderDTOS){
                        //若有未完成订单则把订单状态返回
                        if(!"2".equals(businessOrderDTO.getStatus())){
                            orderId = businessOrderDTO.getBusinessOrderId();
                            orderAmount = businessOrderDTO.getAmount();
                            orderStatus = businessOrderDTO.getStatus();
                        }
                     }
                }else {
                    orderId = businessOrderDTOS.get(0).getBusinessOrderId();
                    orderStatus = businessOrderDTOS.get(0).getStatus();
                    orderAmount = businessOrderDTOS.get(0).getAmount();
                }
                incomeRecordDTO.setPayDate(businessOrderDTOS.get(0).getPayDate());
            }
            //根据用户income表中的受益人userId查询受益人信息
            UserInfoDTO userInfoDTO = userServiceClient.getUserInfoFromUserId(incomeRecordDTO.getSysUserId());
            UserInfoDTO nextUserInfoDTO = userServiceClient.getUserInfoFromUserId(incomeRecordDTO.getNextUserId());
            incomeRecordDTO.setOrderStatus(orderId);
            incomeRecordDTO.setOrderAmount(orderAmount);
            incomeRecordDTO.setOrderStatus(orderStatus);
            if(null != nextUserInfoDTO){
                incomeRecordDTO.setUserTypeNow(userInfoDTO.getUserType());
            }
            if(null != nextUserInfoDTO){
                incomeRecordDTO.setNextUserTypeNow(nextUserInfoDTO.getUserType());
            }
        }
        return incomeRecordDTOS;
    }

    public int getIncomeRecordCountByPageParam(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        return incomeMapper.getIncomeRecordCountByPageParam(pageParamVoDTO);
    }

    public List<IncomeRecordDTO> queryIncomeByParameters(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        List<IncomeRecordDTO> incomeRecordDTOS = incomeMapper.getIncomeRecordByPageParam(pageParamVoDTO);
        for (IncomeRecordDTO incomeRecordDTO: incomeRecordDTOS) {
            try {
                if (StringUtils.isNotBlank(incomeRecordDTO.getNickName())) {
                    incomeRecordDTO.setNickName(URLDecoder.decode(incomeRecordDTO.getNickName(),"utf-8"));
                }
                if (StringUtils.isNotBlank(incomeRecordDTO.getNextUserNickName())) {
                    incomeRecordDTO.setNextUserNickName(URLDecoder.decode(incomeRecordDTO.getNextUserNickName(),"utf-8"));
                }
            } catch (UnsupportedEncodingException e) {
                logger.info("service -- 佣金奖励详情queryIncomeByParameters方法转换nickName失败" );
                e.printStackTrace();
            }
            UserInfoDTO selfUserInfoDTO = userServiceClient.getUserInfoFromUserId(incomeRecordDTO.getSysUserId());
            UserInfoDTO nextUserInfoDTO = userServiceClient.getUserInfoFromUserId(incomeRecordDTO.getNextUserId());
            incomeRecordDTO.setUserTypeNow(selfUserInfoDTO.getUserType());
            incomeRecordDTO.setNextUserTypeNow(nextUserInfoDTO.getUserType());
        }
        return incomeRecordDTOS;

    }

    public List<MonthTransactionRecordDTO> queryMonthRecordByParentRelation(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        List<MonthTransactionRecordDTO> monthTransactionRecordDTOS = incomeMapper.queryMonthRecordByParentRelation(pageParamVoDTO);
        for (MonthTransactionRecordDTO monthTransactionRecordDTO: monthTransactionRecordDTOS) {
            try {
                if (StringUtils.isNotBlank(monthTransactionRecordDTO.getNickName())) {
                    monthTransactionRecordDTO.setNickName(URLDecoder.decode(monthTransactionRecordDTO.getNickName(),"utf-8"));
                }
                if (StringUtils.isNotBlank(monthTransactionRecordDTO.getNextUserNickName())) {
                    monthTransactionRecordDTO.setNextUserNickName(URLDecoder.decode(monthTransactionRecordDTO.getNextUserNickName(),"utf-8"));
                }
            } catch (UnsupportedEncodingException e) {
                logger.info("service -- 月度奖励详情queryMonthRecordByParentRelation方法转换nickName失败" );
                e.printStackTrace();
            }
            UserInfoDTO selfUserInfoDTO = userServiceClient.getUserInfoFromUserId(monthTransactionRecordDTO.getUserId());
            UserInfoDTO nextUserInfoDTO = userServiceClient.getUserInfoFromUserId(monthTransactionRecordDTO.getNextUserId());
            monthTransactionRecordDTO.setUserTypeNow(selfUserInfoDTO.getUserType());
            monthTransactionRecordDTO.setNextUserTypeNow(nextUserInfoDTO.getUserType());
        }
        return monthTransactionRecordDTOS;
    }


    public int getIncomeRecordCountByIncomeManagement(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        return incomeMapper.getIncomeRecordCountByIncomeManagement(pageParamVoDTO);
    }

    public int queryMonthRecordCountByParentRelation(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        return incomeMapper.queryMonthRecordCountByParentRelation(pageParamVoDTO);
    }

    public List<ExportIncomeRecordExcelDTO> exportExcelIncomeRecord(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO) {
        List<ExportIncomeRecordExcelDTO> exportIncomeRecordExcelDTOS = incomeMapper.exportExcelIncomeRecord(pageParamVoDTO);
        for (ExportIncomeRecordExcelDTO exportIncomeRecordExcelDTO : exportIncomeRecordExcelDTOS){
            try {
            if (StringUtils.isNotBlank(exportIncomeRecordExcelDTO.getNickName())) {
                exportIncomeRecordExcelDTO.setNickName(URLDecoder.decode(exportIncomeRecordExcelDTO.getNickName(),"utf-8"));
            }
            if (StringUtils.isNotBlank(exportIncomeRecordExcelDTO.getNextUserNickName())) {
                exportIncomeRecordExcelDTO.setNextUserNickName(URLDecoder.decode(exportIncomeRecordExcelDTO.getNextUserNickName(),"utf-8"));
            }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return exportIncomeRecordExcelDTOS;
    }
}
