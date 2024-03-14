package de.telran.deliveryproject.entity;

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
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "de.telran.deliveryproject.generator.UuidTimeSequenceGenerator")
    @Column(name = "r_id")
    private UUID rId;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private Set<Menu> menu;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(rId, that.rId) && Objects.equals(title, that.title) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, title, address);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rId=" + rId +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                ", createdAt=" + createdAt +
                '}';
    }
}
