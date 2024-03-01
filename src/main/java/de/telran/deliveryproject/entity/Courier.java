package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.Rating;
import de.telran.deliveryproject.entity.enums.StatusEmployee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public class Courier {
    private UUID cId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String phoneNumber;
    private String email;
    private StatusEmployee statusEmployee;
    private Rating rating;
    private LocalDateTime hireDate;
    private LocalDateTime terminationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courier courier = (Courier) o;
        return Objects.equals(cId, courier.cId) && Objects.equals(firstName, courier.firstName) && Objects.equals(lastName, courier.lastName) && Objects.equals(phoneNumber, courier.phoneNumber) && Objects.equals(email, courier.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, firstName, lastName, phoneNumber, email);
    }
}
