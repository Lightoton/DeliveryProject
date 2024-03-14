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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "d_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "de.telran.deliveryproject.generator.UuidTimeSequenceGenerator")
    private UUID dId;

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "m_id")
    private Manager manager;

    @OneToMany
    @JoinColumn(name = "sup_manager_id", referencedColumnName = "sm_id")
    private Set<SupportManager> supportManagers;

    @OneToMany
    @JoinColumn(name = "courier_id", referencedColumnName = "c_id")
    private Set<Courier> couriers;

    @OneToMany
    @JoinColumn(name = "client_id", referencedColumnName = "u_id")
    private Set<Client> clients;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "o_id")
    private Set<Order> orders;

    @OneToMany
    @JoinColumn(name = "restaurant_id", referencedColumnName = "r_id")
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

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", manager=" + manager +
                ", supportManagers=" + supportManagers +
                ", couriers=" + couriers +
                ", clients=" + clients +
                ", orders=" + orders +
                ", restaurants=" + restaurants +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
