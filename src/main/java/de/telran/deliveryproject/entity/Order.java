package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class Order {
    private UUID oId;
    private StatusOrder statusOrder;
    private BigDecimal finalAmount;
    private Restaurant restaurant;
    private Client client;
    private SupportManager supportManager;
    private Set<Courier> couriers;
    private LocalDateTime createdAt;
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
