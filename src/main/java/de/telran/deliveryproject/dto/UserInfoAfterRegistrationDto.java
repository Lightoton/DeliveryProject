package de.telran.deliveryproject.dto;

import lombok.Value;

@Value
public class UserInfoAfterRegistrationDto {
    String status = "COMPLETED";
    String firstname;
    String lastname;
    String phoneNumber;
    String email;
}
