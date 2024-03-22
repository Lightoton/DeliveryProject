package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.telran.deliveryproject.entity.enums.Rating;
import de.telran.deliveryproject.entity.enums.StatusCourier;
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
@Table(name = "couriers")
public class Courier {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    private UUID cId;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status_courier")
    @Enumerated(EnumType.STRING)
    private StatusCourier statusCourier;

    @Column(name = "status_employee")
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "termination_date")
    private LocalDateTime terminationDate;

    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;


    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

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
                ", statusCourier=" + statusCourier +
                ", statusEmployee=" + statusEmployee +
                ", rating=" + rating +
                ", hireDate=" + hireDate +
                ", terminationDate=" + terminationDate +
                ", userInfo=" + userInfo +
                '}';
    }
}
