package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    @GetMapping("/show_food/{foodId}")
    public Food showFoodById(@PathVariable String foodId){
        return foodService.showFood(foodId);
    }

    @GetMapping("/show_foods_by_menu/{menuId}")
    public Set<Food> showAllFoodsByMenuId(@PathVariable String menuId){
        return foodService.showAllFoodsByMenuId(menuId);
    }
}
