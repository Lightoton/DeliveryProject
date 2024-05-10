package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.annotation.CreateUserInfoMapping;
import de.telran.deliveryproject.annotation.DeleteUserInfoByIdMapping;
import de.telran.deliveryproject.annotation.GetUserInfoByIdMapping;
import de.telran.deliveryproject.dto.UserInfoAfterRegistrationDto;
import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Validated
@RestController
@RequestMapping("/user_info")
@RequiredArgsConstructor
@Tag(name = "User's information.", description = "Interaction with user information.",
        externalDocs = @ExternalDocumentation(description = "Here's all the documentation: ",
                url = "https://github.com/Lightoton/DeliveryProject/blob/main/README.md"))
public class UserInfoController {
    private final UserInfoService userInfoService;
    @GetUserInfoByIdMapping(path = "/getUserInfo/{infoId}")
    public UserInfoDto getUserInfo(@UuidChecker @PathVariable String infoId){
        return userInfoService.getUserInfoDto(infoId);
    }

    @CreateUserInfoMapping(path = "/create_user_info_new")
    public UserInfoAfterRegistrationDto createUserInfoNew(@RequestBody UserInfoDto userInfoDto){
        return userInfoService.createUserInfoByDto(userInfoDto);
    }

    @PutMapping("update_info/{infoId}")
    public UserInfoDto updateUserInfo(@UuidChecker @PathVariable String infoId, @RequestBody UserInfoDto userInfoDto){
        return userInfoService.updateUserInfoDtoById(infoId,userInfoDto);
    }
    @GetUserInfoByIdMapping(path = "/showUserInfo/{infoId}")
    public UserInfo showUserById(@UuidChecker @PathVariable String infoId) {
        return userInfoService.showUser(infoId);
    }


    @CreateUserInfoMapping(path = "/create_user_info")
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.creatUserInfo(userInfo);
    }


    @DeleteUserInfoByIdMapping(path = "/delete_user_info/{infoId}")
    public void deleteUserInfoById(@PathVariable String infoId) {
        userInfoService.deleteUserInfo(infoId);
    }

    @GetMapping("/get_userinfo/{username}")
    public Optional<UserInfo> getUserInfoByUsername(@PathVariable String username) {
        return userInfoService.getUserInfoByUsername(username);
    }
}
