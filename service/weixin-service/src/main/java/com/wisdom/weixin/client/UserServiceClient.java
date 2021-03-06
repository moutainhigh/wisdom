package com.wisdom.weixin.client;

import com.wisdom.common.dto.user.UserInfoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(value = "/getUserInfo",method=RequestMethod.POST)
    List<UserInfoDTO> getUserInfo(@RequestBody UserInfoDTO userInfoDTO);

    @RequestMapping(value = "/getUserInfoFromUserId",method=RequestMethod.GET)
    UserInfoDTO getUserInfoFromUserId(@RequestParam(value = "userId") String userId);

    @RequestMapping(value = "/updateUserInfo",method=RequestMethod.POST)
    void updateUserInfo(@RequestBody UserInfoDTO userInfoDTO);

    @RequestMapping(value = "/insertUserInfo",method=RequestMethod.POST)
    void insertUserInfo(@RequestBody UserInfoDTO userInfoDTO);

    @RequestMapping(value = "/queryNextUserByUserId",method=RequestMethod.GET)
    List<UserInfoDTO> queryNextUserByUserId(@RequestParam(value = "userId") String userId);
}
