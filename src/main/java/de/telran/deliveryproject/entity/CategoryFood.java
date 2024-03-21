package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.telran.deliveryproject.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foods_category")
public class CategoryFood {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "categoryFood")
    private Set<Food> foods;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "menu_id")
    private Menu menu;

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

    @Override
    public String toString() {
        return "CategoryFood{" +
                "categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", foods=" + foods +
                ", createdAt=" + createdAt +
                '}';
    }
}
