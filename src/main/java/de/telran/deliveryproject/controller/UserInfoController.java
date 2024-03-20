package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_info")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;
    @GetMapping("/showUserInfo/{infoId}")
    public UserInfo showUserById(@PathVariable String infoId){
        return userInfoService.showUser(infoId);
    }
}
