package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.StatusEmployee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public class SupportManager {
    private UUID smId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String phoneNumber;
    private String email;
    private StatusEmployee statusEmployee;
    private LocalDateTime hireDate;
    private LocalDateTime terminationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportManager that = (SupportManager) o;
        return Objects.equals(smId, that.smId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smId, firstName, lastName, phoneNumber, email);
    }
}
