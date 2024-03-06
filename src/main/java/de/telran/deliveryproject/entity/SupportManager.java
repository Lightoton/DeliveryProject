package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.StatusEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suport_managers")
public class SupportManager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sm_Id")
    private UUID smId;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status_employee")
    private StatusEmployee statusEmployee;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "termination_date")
    private LocalDateTime terminationDate;


    private UserInfo info;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportManager that = (SupportManager) o;
        return Objects.equals(smId, that.smId) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smId, salary);
    }
}
