package de.telran.deliveryproject.dto;

import lombok.Data;

@Data
public class ClientAfterRegistrationDto {
    final String status = "COMPLETED";
    String address;
    String dateOfBirth;
    UserInfoAfterRegistrationDto userInfoAfterRegistrationDto;
}
