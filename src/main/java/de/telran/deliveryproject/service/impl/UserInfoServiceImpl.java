package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.dto.UserInfoAfterRegistrationDto;
import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.exception.UserInformationIsExistException;
import de.telran.deliveryproject.exception.UserInformationNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.generator.PasswordGenerator;
import de.telran.deliveryproject.mapper.UserInfoMapper;
import de.telran.deliveryproject.repository.UserInfoRepository;
import de.telran.deliveryproject.service.interfaces.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserInfoMapper mapper;

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

    @Override
    public UserInfoDto getUserInfoDto(String id) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(UUID.fromString(id));
        return mapper.toDto(userInfo.orElseThrow(() -> new UserInformationNotFoundException(ErrorMessage.USER_INFORMATION_NOT_FOUND)));
    }

    @Override
    @Transactional
    public UserInfoDto updateUserInfoDtoById(String id, UserInfoDto userInfoDto) {
        UserInfo getUserInfo = showUser(id);

        if ((!getUserInfo.getFirstname().equals(userInfoDto.getFirstname())) && (userInfoDto.getFirstname() != null)) {
            getUserInfo.setFirstname(userInfoDto.getFirstname());
        }
        if ((!getUserInfo.getLastname().equals(userInfoDto.getLastname())) && (userInfoDto.getLastname() != null)) {
            getUserInfo.setLastname(userInfoDto.getLastname());
        }
        if ((!getUserInfo.getPhoneNumber().equals(userInfoDto.getPhoneNumber())) && (userInfoDto.getPhoneNumber() != null)) {
            getUserInfo.setPhoneNumber(userInfoDto.getPhoneNumber());
        }
        if ((!getUserInfo.getEmail().equals(userInfoDto.getEmail())) && (userInfoDto.getEmail() != null)) {
            getUserInfo.setEmail(userInfoDto.getEmail());
        }
        userInfoRepository.save(getUserInfo);
        return mapper.toDto(getUserInfo);
    }

    @Override
    public UserInfoAfterRegistrationDto createUserInfoByDto(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userInfoDto.getUsername());
        userInfo.setFirstname(userInfoDto.getFirstname());
        userInfo.setLastname(userInfoDto.getLastname());
        userInfo.setPhoneNumber(userInfoDto.getPhoneNumber());
        userInfo.setEmail(userInfoDto.getEmail());
        if (userInfoDto.getPassword() == null || userInfoDto.getPassword().isEmpty()){
            userInfo.setPassword(PasswordGenerator.generatePasswordBasedOnUUID());
        }else {
            userInfo.setPassword(userInfoDto.getPassword());
        }
        userInfoRepository.save(userInfo);
        System.out.println(userInfo);
        return mapper.afterRegistrationDto(userInfo);
    }

}
