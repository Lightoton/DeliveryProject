package de.telran.deliveryproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.deliveryproject.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authority")
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "auth_id")
    private UUID id;

    @Column(name = "authority")
    private String authority;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
