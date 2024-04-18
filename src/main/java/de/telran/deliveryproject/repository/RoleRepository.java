package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Set<Role> getRoleByRoleName(String roleName);
}
