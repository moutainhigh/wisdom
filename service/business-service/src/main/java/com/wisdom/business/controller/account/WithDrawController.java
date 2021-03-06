package com.wisdom.business.controller.account;

import com.wisdom.business.client.UserServiceClient;
import com.wisdom.business.service.account.WithDrawService;
import com.wisdom.business.util.UserUtils;
import com.wisdom.common.constant.ConfigConstant;
import com.wisdom.common.constant.RealNameResultEnum;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.business.interceptor.LoginRequired;
import com.wisdom.common.dto.account.*;
import com.wisdom.common.dto.user.RealNameInfoDTO;
import com.wisdom.common.dto.user.UserInfoDTO;
import com.wisdom.common.dto.product.ProductDTO;
import com.wisdom.common.dto.system.*;
import com.wisdom.common.util.*;
import com.wisdom.common.util.excel.ExportExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 直播板块
 * @author frank
 * @date 2015-10-14
 */

@Controller
@RequestMapping(value = "withdraw")
public class WithDrawController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserServiceClient userServiceClient;

	@Autowired
	private WithDrawService withDrawService;


	/**
	 * 用户进行提现操作
	 */
	@RequestMapping(value = "withDrawMoneyFromAccount", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO withDrawMoneyFromAccount(@RequestBody WithDrawRecordDTO withDrawRecordDTO ,
										 HttpServletRequest request,
										 HttpSession session) {
		long startTime = System.currentTimeMillis();
		logger.info("用户进行提现操作==={}" , startTime);
		ResponseDTO<AccountDTO> result = new ResponseDTO<>();

		UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

		RedisLock redisLock = new RedisLock("withDrawMoney"+userInfoDTO.getId());

		try
		{
			redisLock.lock();

			//判断手机号和验证码是否正确
			LoginDTO loginDTO = new LoginDTO();
			loginDTO.setUserPhone(withDrawRecordDTO.getMobile());
			loginDTO.setCode(withDrawRecordDTO.getValidCode());
			if(LoginUtil.processValidateCode(loginDTO).equals(StatusConstant.VALIDATECODE_ERROR))
			{
				logger.info("判断手机号和验证码错误");
				result.setResult(StatusConstant.FAILURE);
				result.setErrorInfo("手机验证码错误");
				return result;
			}

			//判断用户的提现次数
			WithDrawRecordDTO withDrawRecord = new WithDrawRecordDTO();
			withDrawRecord.setSysUserId(userInfoDTO.getId());
			List<WithDrawRecordDTO> withDrawRecordDTOList = withDrawService.getWithdrawRecordInfo(withDrawRecord);

			int withDrawNum = 0;
			for(WithDrawRecordDTO drawRecordDTO:withDrawRecordDTOList)
			{
				if(DateUtils.formatDate(new Date()).equals(DateUtils.formatDate(drawRecordDTO.getCreateDate())))
				{
					withDrawNum++;
				}
			}
			logger.info("用户的提现次数==={}",withDrawNum);
			if(withDrawNum> ConfigConstant.MAX_WITHDRAW_NUM)
			{
				result.setResult(StatusConstant.FAILURE);
				result.setErrorInfo("超出当日最大提现次数");
				return result;
			}


			RealNameInfoDTO realNameInfoDTO = userServiceClient.verifyUserIdentify(withDrawRecordDTO.getIdentifyNumber(),withDrawRecordDTO.getUserName());
			//判断提现的身份证是否合法
			if (RealNameResultEnum.MATCHING.getCode().equals(realNameInfoDTO.getCode()))
			{
				logger.info("提现的身份证合法");
				userInfoDTO.setIdentifyNumber(withDrawRecordDTO.getIdentifyNumber());
				userInfoDTO.setNickname(userInfoDTO.getNickname());
				userServiceClient.updateUserInfo(userInfoDTO);
			}
			else
			{
				logger.info("身份证和姓名不匹配");
				result.setResult(StatusConstant.FAILURE);
				result.setErrorInfo("身份证和姓名不匹配");
				return  result;
			}

			String openid = WeixinUtil.getUserOpenId(session,request);
			logger.info("提现用户openID==={}",openid);
			if(withDrawRecordDTO.getMoneyAmount()>=ConfigConstant.MAX_WITHDRAW_AMOUNT)
			{
				logger.info("提现金额超出最大额度");
				result.setErrorInfo("提现金额超出最大额度");
				result.setResult(StatusConstant.FAILURE);
			}
			else if(withDrawRecordDTO.getMoneyAmount()<ConfigConstant.MIN_WITHDRAW_AMOUNT)
			{
				logger.info("提现金额小于最低额度");
				result.setErrorInfo("提现金额小于最低额度");
				result.setResult(StatusConstant.FAILURE);
			}
			else if(withDrawRecordDTO.getMoneyAmount()>=ConfigConstant.CHECK_WITHDRAW_AMOUNT)
			{
				withDrawService.withDrawMoneyFromAccount(withDrawRecordDTO.getMoneyAmount(),request,openid,true);
				result.setErrorInfo("CHECK_WITHDRAW_AMOUNT");
				result.setResult(StatusConstant.SUCCESS);
			}
			else
			{
				withDrawService.withDrawMoneyFromAccount(withDrawRecordDTO.getMoneyAmount(),request,openid,false);
				result.setResult(StatusConstant.SUCCESS);
			}
		}
		catch (Exception e)
		{
			logger.error("提现异常，异常信息为，{}"+e.getMessage(),e);
			e.printStackTrace();
			result.setErrorInfo("提现失败,请联系客服人员处理");
			result.setResult(StatusConstant.FAILURE);
		}
		finally {
			redisLock.unlock();
		}
		logger.info("用户进行提现操作{}毫秒", (System.currentTimeMillis() - startTime));
		return result;
	}

	/**
	 * 查询所有提现数据
	 * @param pageParamDTO
	 * @return
	 *//*
	@RequestMapping(value = "getAllWithdraw", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> getAllWithdraw(@RequestBody PageParamDTO<WithDrawRecordDTO> pageParamDTO) {
		long startTime = System.currentTimeMillis();
		logger.info("用户进行提现操作==={}" , startTime);
		ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> responseDTO = new ResponseDTO<>();
		PageParamDTO<List<WithDrawRecordDTO>> page = withDrawService.queryAllWithdraw(pageParamDTO);
		responseDTO.setResponseData(page);
		responseDTO.setResult(StatusConstant.SUCCESS);
		logger.info("用户进行提现操作{}毫秒", (System.currentTimeMillis() - startTime));
		return responseDTO;
	}*/

	/**
	 * 解冻超额提现
	 * @return
	 */
	@RequestMapping(value = "deFrozenWithDrawRecord", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO deFrozenWithDrawRecord(@RequestParam String withDrawRecordId,
									   HttpServletRequest request)
	{
		long startTime = System.currentTimeMillis();
		logger.info("解冻超额提现==={}开始" , startTime);
		ResponseDTO responseDTO = new ResponseDTO();
		RedisLock redisLock = new RedisLock("deFrozenWithDrawRecord"+withDrawRecordId);
		try
		{
			redisLock.lock();
			WithDrawRecordDTO withDrawRecordDTO = new WithDrawRecordDTO();
			withDrawRecordDTO.setId(withDrawRecordId);
			logger.info("提现id==={}" , withDrawRecordId);
			List<WithDrawRecordDTO> withDrawRecordDTOList = withDrawService.getWithdrawRecordInfo(withDrawRecordDTO);

			if(withDrawRecordDTOList.size()>0)
			{
				withDrawRecordDTO = withDrawRecordDTOList.get(0);
				if(withDrawRecordDTO.getStatus().equals("0"))
				{
					withDrawService.deFrozenWithDrawRecord(withDrawRecordDTO,request);
					responseDTO.setResult(StatusConstant.SUCCESS);
				}
				else
				{
					responseDTO.setResult(StatusConstant.FAILURE);
				}
			}
			else
			{
				responseDTO.setResult(StatusConstant.FAILURE);
			}
		}
		catch (Exception e)
		{
			logger.error("解冻超额提现异常，异常信息为，{}"+e.getMessage(),e);
			e.printStackTrace();
			responseDTO.setResult(StatusConstant.FAILURE);
		}
		finally {
			redisLock.unlock();
		}
		logger.info("解冻超额提现{}毫秒", (System.currentTimeMillis() - startTime));
		return responseDTO;
	}

	/**
	 * 提现审核
	 * @param
	 * @return
	 */
	@RequestMapping(value = "updateWithdrawById", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO updateWithdrawById(@RequestBody WithDrawRecordDTO withDrawRecordDTO,HttpServletRequest request) {
		long startTime = System.currentTimeMillis();
		logger.info("提现审核==={}开始" , startTime);
		ResponseDTO responseDTO = new ResponseDTO<>();

		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(withDrawRecordDTO.getSysUserId());
		List<UserInfoDTO> userInfoDTOList = userServiceClient.getUserInfo(userInfoDTO);
		String openId ="";
		if (userInfoDTOList != null && userInfoDTOList.size() > 0) {
			openId = userInfoDTOList.get(0).getUserOpenid();
		}
		JedisUtils.set("openid",openId,90000);
		try {
			Map<String,String> result = withDrawService.updateWithdrawById(withDrawRecordDTO,request);
			if(result.get("result").equals("success")){
				logger.info("提现审核成功");
				responseDTO.setResult(StatusConstant.SUCCESS);
				responseDTO.setErrorInfo(result.get("message"));
			}else{
				logger.info("提现审核失败");
				responseDTO.setResult(StatusConstant.FAILURE);
				responseDTO.setErrorInfo(result.get("message"));
			}
		} catch (Exception e) {
			logger.error("提现审核异常，异常信息为，{}"+e.getMessage(),e);
			e.printStackTrace();
			responseDTO.setResult(StatusConstant.FAILURE);
			responseDTO.setErrorInfo("提现审核拒绝");
		}
		logger.info("提现审核,耗时{}毫秒", (System.currentTimeMillis() - startTime));
		return responseDTO;
	}

	/**
	 * 根据条件查询提现信息
	 * @return
	 */
	@RequestMapping(value = "queryWithdrawsByParameters", method = {RequestMethod.POST, RequestMethod.GET})
	@LoginRequired
	public
	@ResponseBody
	ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>>  queryWithdrawsByParameters(@RequestBody PageParamVoDTO<ProductDTO> pageParamVoDTO) {
		long startTime = System.currentTimeMillis();
		logger.info("条件查询提现信息==={}开始" , startTime);
		logger.info("条件查询提现信息是否导出数据==={}" , pageParamVoDTO.getIsExportExcel());
		ResponseDTO<PageParamDTO<List<WithDrawRecordDTO>>> responseDTO = new ResponseDTO<>();
		//设定起始时间
		String startDate = "1990-01-01";
		if (!"0".equals(pageParamVoDTO.getTimeType())){
			pageParamVoDTO.setStartTime("".equals(pageParamVoDTO.getStartTime()) ? startDate : pageParamVoDTO.getStartTime());
			pageParamVoDTO.setEndTime(CommonUtils.getEndDate(pageParamVoDTO.getEndTime()));
		}
		PageParamDTO<List<WithDrawRecordDTO>> page = withDrawService.queryWithdrawsByParameters(pageParamVoDTO);
		if("Y".equals(pageParamVoDTO.getIsExportExcel())) {
			try {
				String[] orderHeaders = {"用户ID", "用户名", "用户等级", "手机号", "提现金额", "提现状态" ,"交易流水号", "姓名", "银行卡",
						"开户行地址","身份证号", "提现申请时间", "提现当前状态时间"};
				ExportExcel<ExportWithDrawRecordExcelDTO> ex = new ExportExcel<>();
				List<ExportWithDrawRecordExcelDTO> excelList = new ArrayList<>();
				for (WithDrawRecordDTO withDrawRecordDTO : page.getResponseData()) {
					ExportWithDrawRecordExcelDTO exportWithDrawRecordExcelDTO = new ExportWithDrawRecordExcelDTO();
					exportWithDrawRecordExcelDTO.setCreateDate(DateUtils.formatDate(withDrawRecordDTO.getCreateDate(),"yyyy-MM-dd HH:mm:ss"));
					exportWithDrawRecordExcelDTO.setIdentifyNumber(withDrawRecordDTO.getIdentifyNumber());
					exportWithDrawRecordExcelDTO.setMobile(withDrawRecordDTO.getMobile());
					exportWithDrawRecordExcelDTO.setMoneyAmount(withDrawRecordDTO.getMoneyAmount());
					exportWithDrawRecordExcelDTO.setNickName(withDrawRecordDTO.getNickName());
					exportWithDrawRecordExcelDTO.setStatus(withDrawRecordDTO.getStatus());
					exportWithDrawRecordExcelDTO.setSysUserId(withDrawRecordDTO.getSysUserId());
					exportWithDrawRecordExcelDTO.setUpdateDate(DateUtils.formatDate(withDrawRecordDTO.getUpdateDate(),"yyyy-MM-dd HH:mm:ss"));
					exportWithDrawRecordExcelDTO.setUserType(withDrawRecordDTO.getUserType());
					exportWithDrawRecordExcelDTO.setWithdrawId(withDrawRecordDTO.getWithdrawId());
					exportWithDrawRecordExcelDTO.setUserName(withDrawRecordDTO.getUserName());
					exportWithDrawRecordExcelDTO.setBankCardNumber(withDrawRecordDTO.getBankCardNumber());
					exportWithDrawRecordExcelDTO.setBankCardAddress(withDrawRecordDTO.getBankCardAddress());
					excelList.add(exportWithDrawRecordExcelDTO);

				}
				ByteArrayInputStream in = ex.getWorkbookIn("提现EXCEL文档", orderHeaders, excelList);
				String url = CommonUtils.orderExcelToOSS(in);
				responseDTO.setResult(url);
				logger.info("条件查询提现信息导出Url==={}" , url);
				responseDTO.setErrorInfo(StatusConstant.SUCCESS);
				return responseDTO;
			} catch (Exception e) {
				logger.error("条件查询提现信息导出异常，异常信息为，{}"+e.getMessage(),e);
				e.printStackTrace();
				responseDTO.setErrorInfo(StatusConstant.FAILURE);
			}
		}
		responseDTO.setResponseData(page);
		responseDTO.setResult(StatusConstant.SUCCESS);
		logger.info("条件查询提现信息,耗时{}毫秒", (System.currentTimeMillis() - startTime));
		return responseDTO;
	}
}
