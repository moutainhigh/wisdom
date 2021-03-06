/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.wisdom.system.util;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.wisdom.common.constant.ConfigConstant;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.system.LoginDTO;
import com.wisdom.common.dto.system.UserBusinessTypeDTO;
import com.wisdom.common.dto.system.ValidateCodeDTO;
import com.wisdom.common.dto.user.UserInfoDTO;
import com.wisdom.common.util.JedisUtils;
import com.wisdom.common.util.SpringUtil;
import com.wisdom.system.client.BusinessServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {

	private static BusinessServiceClient businessServiceClient = (BusinessServiceClient) SpringUtil.getBean(BusinessServiceClient.class);

	private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

	private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

	public static UserInfoDTO getUserInfoFromRedis(){
		logger.info("system-service utils == 获取用户信息从redis");

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("logintoken");
		logger.info("用户token值为：{}",token);

		String userInfoStr = JedisUtils.get(token);
		UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

		//开启一个线程，主要用来同步userType信息到redis中
		Runnable processUserInfoSynchronize = new processUserInfoSynchronize(token,userInfoDTO);
		threadExecutorCached.execute(processUserInfoSynchronize);

		return userInfoDTO;
	}

	private static class processUserInfoSynchronize extends Thread {

		private String logintoken;
		private UserInfoDTO userInfoDTO;

		public processUserInfoSynchronize(String logintoken,UserInfoDTO userInfoDTO) {
			this.logintoken = logintoken;
			this.userInfoDTO = userInfoDTO;
		}

		@Override
		public void run() {
			logger.info("utils == 同步userType信息到redis中");

			UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
			userBusinessTypeDTO.setStatus("1");
			userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
			List<UserBusinessTypeDTO> userBusinessTypeDTOList = businessServiceClient.getUserBusinessType(userBusinessTypeDTO);
			if(userBusinessTypeDTOList.size()>0)
			{
				if(!userBusinessTypeDTOList.get(0).getUserType().equals(userInfoDTO.getUserType()))
				{
					userInfoDTO.setUserType(userBusinessTypeDTOList.get(0).getUserType());
					String userInfoStr = (new Gson()).toJson(userInfoDTO);
					JedisUtils.set(logintoken,userInfoStr, ConfigConstant.logintokenPeriod);
				}
			}
		}
	}

	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
}
