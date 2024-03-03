package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class Restaurant {
    private UUID rId;
    private String title;
    private String address;
    private Set<Menu> menu;
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
}
