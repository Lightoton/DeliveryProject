package de.telran.deliveryproject.mapper;

import de.telran.deliveryproject.dto.UserInfoAfterRegistrationDto;
import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserInfoMapper {
    UserInfoDto toDto(UserInfo userInfo);


    UserInfoAfterRegistrationDto afterRegistrationDto(UserInfo userInfo);
}
