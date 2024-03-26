package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.telran.deliveryproject.entity.enums.StatusOrder;
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
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "o_id")
    private UUID id;

    @Column(name = "status_order")
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "r_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "u_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private Set<Courier> couriers;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "sm_id", referencedColumnName = "sm_id")
    private SupportManager supportManager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && statusOrder == order.statusOrder && Objects.equals(finalAmount, order.finalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusOrder, finalAmount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + id +
                ", statusOrder=" + statusOrder +
                ", finalAmount=" + finalAmount +
                ", restaurant=" + restaurant +
                ", client=" + client +
                ", supportManager=" + supportManager +
                ", couriers=" + couriers +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
