package de.telran.deliveryproject.dto;

import de.telran.deliveryproject.entity.enums.Rating;
import lombok.Data;

@Data
public class ClientDto {
    String address;
    String dateOfBirth;
    String rating = Rating.STAR10.name();
    UserInfoDto userInfo;
    String departmentId;
    String roleName;
}
