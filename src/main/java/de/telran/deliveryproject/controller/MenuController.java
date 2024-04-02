package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.service.interfaces.MenuService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/show_menu_by_id/{id}")
    public Menu showMenuById(@UuidChecker @PathVariable String id) {
        return menuService.showAllMenuById(id);
    }


}
