package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_info")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;
    @GetMapping("/showUserInfo/{infoId}")
    public UserInfo showUserById(@PathVariable String infoId){
        return userInfoService.showUser(infoId);
    }

    @PostMapping("/create_user_info")
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.creatUserInfo(userInfo);
    }
    @DeleteMapping("/delete_user_info/{infoId}")
    public void deleteUserInfoById(@PathVariable String infoId){
        userInfoService.deleteUserInfo(infoId);
    }

}
