package de.telran.deliveryproject.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    final String status = "COMPLETED";
    String firstname;
    String lastname;
    String phoneNumber;
    String username;
    String email;
    String password;
}
