package de.telran.deliveryproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class Department {
    private UUID dId;
    private Manager manager;
    private Set<SupportManager> supportManagers;
    private Set<Courier> couriers;
    private Set<Client> clients;
    private Set<Order> orders;
    private Set<Restaurant> restaurants;
    private String address;
    private LocalDateTime createdAt;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(dId, that.dId) && Objects.equals(address, that.address) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dId, address, createdAt);
    }

}
