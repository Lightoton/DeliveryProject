package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final FoodService foodService;
    @GetMapping("/show_all_menu_by_restaurant_title/{restaurantTitle}")
    public Food showFoodById(@PathVariable String restaurantTitle){
        return foodService.showFood(restaurantTitle);
    }
}
