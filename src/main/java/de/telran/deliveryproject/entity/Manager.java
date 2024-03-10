package de.telran.deliveryproject.entity;

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
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "m_id")
    private UUID mId;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "termination_date")
    private LocalDateTime terminationDate;

    @OneToOne
    @JoinColumn(name = "info_id", referencedColumnName = "info_id")
    private UserInfo userInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(mId, manager.mId) && Objects.equals(salary, manager.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, salary);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mId=" + mId +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", terminationDate=" + terminationDate +
                ", userInfo=" + userInfo +
                '}';
    }
}
