/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.wisdom.system.controller;

import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.system.SuggestionDto;
import com.wisdom.common.dto.system.UserInfoDTO;
import com.wisdom.system.client.UserServiceClient;
import com.wisdom.system.interceptor.LoginRequired;
import com.wisdom.system.service.FeedbackService;
import com.wisdom.system.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "feedback")
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 提交建议
     */
    @RequestMapping(value = "suggestionDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO suggestion(@RequestParam String suggestion) {
        ResponseDTO<SuggestionDto> result = new ResponseDTO<>();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        String userId=userInfoDTO.getId();
        result.setResponseData(feedbackService.addSuggestion(userId,suggestion));
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }
}
