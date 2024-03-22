package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Department;
import de.telran.deliveryproject.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
