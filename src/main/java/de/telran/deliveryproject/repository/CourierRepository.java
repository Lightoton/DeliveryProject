package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Repository
public interface CourierRepository extends JpaRepository<Courier, UUID> {

    @Query("SELECT c FROM Courier c INNER JOIN c.userInfo u WHERE u.firstname = :name")
    Optional<Courier> findByFirstName(@Param("name") String name);

    @Query("SELECT c FROM Courier c WHERE c.statusCourier = 'FREE'")
    Set<Courier> findFreeCouriers();

}
