package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public class Manager {
    private UUID mId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String phoneNumber;
    private String email;
    private LocalDateTime hireDate;
    private LocalDateTime terminationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(mId, manager.mId) && Objects.equals(firstName, manager.firstName) && Objects.equals(lastName, manager.lastName) && Objects.equals(phoneNumber, manager.phoneNumber) && Objects.equals(email, manager.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, firstName, lastName, phoneNumber, email);
    }
}
