package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.exception.UserInformationIsExistException;
import de.telran.deliveryproject.exception.UserInformationNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.UserInfoRepository;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserInfo showUser(String id) {
        return userInfoRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new UserInformationNotFoundException(ErrorMessage.USER_INFORMATION_NOT_FOUND));
    }

    @Override
    public UserInfo creatUserInfo(UserInfo userInfo) {
        if (userInfoRepository.findByEmail(userInfo.getEmail()) != null){
            throw new UserInformationIsExistException(ErrorMessage.USER_INFORMATION_IS_EXIST);
        }else return userInfoRepository.saveAndFlush(userInfo);
    }

    @Override
    public void deleteUserInfo(String id) {
        userInfoRepository.deleteById(UUID.fromString(id));
    }

}
