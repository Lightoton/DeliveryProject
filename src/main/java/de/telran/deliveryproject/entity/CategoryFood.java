package de.telran.deliveryproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorys")
public class CategoryFood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "title")
    private String title;

    private Set<Food> foods;

    @Column(name = "created_at")
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
