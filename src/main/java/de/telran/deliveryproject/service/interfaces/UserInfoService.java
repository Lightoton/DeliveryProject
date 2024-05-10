package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.dto.UserInfoAfterRegistrationDto;
import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.UserInfo;

import java.util.Optional;

public interface UserInfoService {
    UserInfo showUser(String id);

    UserInfo creatUserInfo(UserInfo userInfo);

    void deleteUserInfo(String id);

    UserInfoDto getUserInfoDto(String id);

    UserInfoDto updateUserInfoDtoById(String id, UserInfoDto userInfoDto);
    UserInfoAfterRegistrationDto createUserInfoByDto(UserInfoDto userInfoDto);

    Optional<UserInfo> getUserInfoByUsername(String username);
}
