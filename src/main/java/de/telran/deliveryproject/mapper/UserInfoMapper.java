package de.telran.deliveryproject.mapper;

import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDto toDto(UserInfo userInfo);
}
