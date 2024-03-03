package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public class Food {
    private UUID fId;
    private String title;
    private Double calorie;
    private BigDecimal price;
    private LocalDateTime cookingTime;
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(fId, food.fId) && Objects.equals(title, food.title) && Objects.equals(price, food.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fId, title, price);
    }
}
