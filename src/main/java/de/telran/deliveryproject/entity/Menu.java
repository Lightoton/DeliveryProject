package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class Menu {
    private UUID menuId;
    private String title;
    private BigDecimal averagePrice;
    private Set<CategoryFood> categoryFoods;
    private LocalDateTime createdAt;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId) && Objects.equals(title, menu.title) && Objects.equals(averagePrice, menu.averagePrice) && Objects.equals(createdAt, menu.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, title, averagePrice, createdAt);
    }
}
