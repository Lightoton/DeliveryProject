package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Department;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.service.interfaces.DepartmentService;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/show_department/{id}")
    public Department showDepartmentById(@PathVariable String id){
        return departmentService.showDepartmentById(id);
    }
}
