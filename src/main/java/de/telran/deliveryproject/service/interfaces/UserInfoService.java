package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.UserInfo;

public interface UserInfoService {
    UserInfo showUser(String id);
    UserInfo creatUserInfo(UserInfo userInfo);
}
