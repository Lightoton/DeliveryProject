package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Manager;
import de.telran.deliveryproject.entity.SupportManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupportManagerRepository extends JpaRepository<SupportManager, UUID> {
}
