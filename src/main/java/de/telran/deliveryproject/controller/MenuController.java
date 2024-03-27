package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.entity.Restaurant;
import de.telran.deliveryproject.service.interfaces.FoodService;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
