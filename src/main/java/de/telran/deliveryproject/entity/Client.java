package de.telran.deliveryproject.entity;

import de.telran.deliveryproject.entity.enums.Rating;
import de.telran.deliveryproject.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    private UUID uId;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @OneToOne
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(uId, client.uId) && Objects.equals(dateOfBirth, client.dateOfBirth) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, dateOfBirth, address);
    }

    @Override
    public String toString() {
        return "Client{" +
                "uId=" + uId +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", registrationDate=" + registrationDate +
                ", userInfo=" + userInfo +
                '}';
    }
}
