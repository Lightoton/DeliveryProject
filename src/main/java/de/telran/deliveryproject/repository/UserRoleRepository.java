package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Role;
import de.telran.deliveryproject.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, UserInfo>{

}
