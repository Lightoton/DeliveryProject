package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.Rating;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public class Client {
    private UUID uId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private String address;
    private Rating rating;
    private LocalDateTime registrationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(uId, client.uId) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(dateOfBirth, client.dateOfBirth) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, firstName, lastName, dateOfBirth, phoneNumber, email);
    }
}
