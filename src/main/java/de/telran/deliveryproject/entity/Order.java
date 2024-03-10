package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private UUID id;

    @Column(name = "status_order")
    private StatusOrder statusOrder;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "r_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "u_id")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sup_manager_id", referencedColumnName = "sm_id")
    private SupportManager supportManager;

    @OneToMany
    @JoinColumn(name = "courier_id", referencedColumnName = "c_id")
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
