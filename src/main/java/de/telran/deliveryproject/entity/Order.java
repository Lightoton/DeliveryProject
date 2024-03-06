package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "o_id")
    private UUID oId;

    @Column(name = "status_order")
    private StatusOrder statusOrder;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;


    private Restaurant restaurant;
    private Client client;
    private SupportManager supportManager;
    private Set<Courier> couriers;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(oId, order.oId) && statusOrder == order.statusOrder && Objects.equals(finalAmount, order.finalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, statusOrder, finalAmount);
    }
}
