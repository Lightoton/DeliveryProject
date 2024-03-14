package de.telran.deliveryproject.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "de.telran.deliveryproject.generator.UuidTimeSequenceGenerator")
    @Column(name = "menu_id")
    private UUID menuId;

    @Column(name = "title")
    private String title;

    @Column(name = "average_price")
    private BigDecimal averagePrice;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<CategoryFood> categoryFoods;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId) && Objects.equals(title, menu.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, title);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", title='" + title + '\'' +
                ", averagePrice=" + averagePrice +
                ", categoryFoods=" + categoryFoods +
                ", createdAt=" + createdAt +
                '}';
    }
}
