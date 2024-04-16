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
    Client toEntity(ClientDto clientDto);


    @Mapping(target = "address",source = "address")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "userInfoAfterRegistrationDto",source = "userInfo")
    ClientAfterRegistrationDto toDto(Client client);
}
