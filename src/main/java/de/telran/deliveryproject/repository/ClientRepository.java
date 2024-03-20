package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
