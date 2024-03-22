package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.telran.deliveryproject.entity.enums.StatusEmployee;
import de.telran.deliveryproject.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "support_managers")
public class SupportManager {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "sm_id")
    private UUID smId;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status_employee")
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "termination_date")
    private LocalDateTime terminationDate;

    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

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

    @Override
    public String toString() {
        return "SupportManager{" +
                "smId=" + smId +
                ", salary=" + salary +
                ", statusEmployee=" + statusEmployee +
                ", hireDate=" + hireDate +
                ", terminationDate=" + terminationDate +
                ", userInfo=" + userInfo +
                '}';
    }
}
