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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "d_id")
    private UUID dId;


    private Manager manager;
    private Set<SupportManager> supportManagers;
    private Set<Courier> couriers;
    private Set<Client> clients;
    private Set<Order> orders;
    private Set<Restaurant> restaurants;


    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(dId, that.dId) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dId, address);
    }
}
