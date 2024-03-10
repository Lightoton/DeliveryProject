package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.Rating;
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
@Table(name = "couriers")
public class Courier {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID cId;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status_employee")
    private StatusEmployee statusEmployee;

    @Column(name = "rating")
    private Rating rating;

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
        Courier courier = (Courier) o;
        return Objects.equals(cId, courier.cId) && Objects.equals(salary, courier.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, salary);
    }

    @Override
    public String toString() {
        return "Courier{" +
                "cId=" + cId +
                ", salary=" + salary +
                ", statusEmployee=" + statusEmployee +
                ", rating=" + rating +
                ", hireDate=" + hireDate +
                ", terminationDate=" + terminationDate +
                ", userInfo=" + userInfo +
                '}';
    }
}
