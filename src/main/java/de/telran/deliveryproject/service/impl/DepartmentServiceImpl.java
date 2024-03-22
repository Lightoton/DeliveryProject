package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Department;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.exception.DepartmentNotFoundException;
import de.telran.deliveryproject.exception.MenuNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.DepartmentRepository;
import de.telran.deliveryproject.repository.MenuRepository;
import de.telran.deliveryproject.service.interfaces.DepartmentService;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public Department showDepartmentById(String id) {
        return departmentRepository.findById(UUID.fromString(id)).orElseThrow(()-> new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_NOT_FOUND));
    }
}
