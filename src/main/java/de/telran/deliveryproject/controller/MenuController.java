package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.service.interfaces.FoodService;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/show_menu_by_id/{id}")
    public Menu showMenuById(@PathVariable String id){
        return menuService.showAllMenuById(id);
    }
}
