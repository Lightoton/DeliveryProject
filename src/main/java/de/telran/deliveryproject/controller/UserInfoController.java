package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.annotation.CustomCreateUserInfo;
import de.telran.deliveryproject.annotation.CustomDeleteUserInfoById;
import de.telran.deliveryproject.annotation.CustomGetUserInfoById;
import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user_info")
@RequiredArgsConstructor
@Tag(name = "User's information.", description = "Interaction with user information.",
        externalDocs = @ExternalDocumentation(description = "Here's all the documentation: ",
                url = "https://github.com/Lightoton/DeliveryProject/blob/main/README.md"))
public class UserInfoController {
    private final UserInfoService userInfoService;

    @CustomGetUserInfoById(path = "/showUserInfo/{infoId}")
    public UserInfo showUserById(@UuidChecker @PathVariable String infoId) {
        return userInfoService.showUser(infoId);
    }


    @CustomCreateUserInfo(path = "/create_user_info")
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.creatUserInfo(userInfo);
    }


    @CustomDeleteUserInfoById(path = "/delete_user_info/{infoId}")
    public void deleteUserInfoById(@PathVariable String infoId) {
        userInfoService.deleteUserInfo(infoId);
    }

}
