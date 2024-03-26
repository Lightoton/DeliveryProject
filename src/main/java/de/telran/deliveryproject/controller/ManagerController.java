package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Manager;
import de.telran.deliveryproject.service.interfaces.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;
    @GetMapping("/show_manager/{managerId}")
    public Manager showManagerById(@PathVariable String managerId){
        return managerService.showManager(managerId);
    }
}
