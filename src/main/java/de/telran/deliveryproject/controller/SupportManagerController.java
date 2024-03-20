package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Manager;
import de.telran.deliveryproject.entity.SupportManager;
import de.telran.deliveryproject.service.interfaces.ManagerService;
import de.telran.deliveryproject.service.interfaces.SupportManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support_manager")
@RequiredArgsConstructor
public class SupportManagerController {
    private final SupportManagerService supportManagerService;
    @GetMapping("/show_support_manager/{supManagerId}")
    private SupportManager showSupportManagerById(@PathVariable String supManagerId){
        return supportManagerService.showSupportManager(supManagerId);
    }
}
