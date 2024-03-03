package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class CategoryFood {
    private UUID categoryId;
    private String title;
    private Set<Food> foods;
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryFood that = (CategoryFood) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, title);
    }
}
