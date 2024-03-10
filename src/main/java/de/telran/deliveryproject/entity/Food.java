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
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "f_id")
    private UUID fId;

    @Column(name = "title")
    private String title;

    @Column(name = "calorie")
    private Double calorie;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cooking_time")
    private LocalDateTime cookingTime;

    @Column(name = "created_at")
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

    @Override
    public String toString() {
        return "Food{" +
                "fId=" + fId +
                ", title='" + title + '\'' +
                ", calorie=" + calorie +
                ", price=" + price +
                ", cookingTime=" + cookingTime +
                ", createdAt=" + createdAt +
                '}';
    }
}
