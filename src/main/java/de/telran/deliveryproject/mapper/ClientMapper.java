package de.telran.deliveryproject.mapper;

import de.telran.deliveryproject.dto.ClientAfterRegistrationDto;
import de.telran.deliveryproject.dto.ClientDto;
import de.telran.deliveryproject.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "userInfo", source = "userInfo")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "userInfo.infoId", ignore = true)
    @Mapping(target = "userInfo.updated_at", ignore = true)
    @Mapping(target = "userInfo.roles", ignore = true)
    @Mapping(target = "UId", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "department", ignore = true)
    Client toEntity(ClientDto clientDto);


    @Mapping(target = "address",source = "address")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "userInfoAfterRegistrationDto",source = "userInfo")
    ClientAfterRegistrationDto toDto(Client client);
}
