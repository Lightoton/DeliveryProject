package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
}
