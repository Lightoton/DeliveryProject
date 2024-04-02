package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.deliveryproject.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "order_d_id")
    private UUID orderDId;

    @Column(name = "quantity_foods")
    private int quantity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @OneToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return quantity == that.quantity && Objects.equals(orderDId, that.orderDId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDId, quantity);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDId=" + orderDId +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", order=" + order +
                ", food=" + food +
                '}';
    }
}
