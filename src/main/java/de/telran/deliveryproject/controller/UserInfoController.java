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
    private UserInfo createUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.creatUserInfo(userInfo);
    }
}
