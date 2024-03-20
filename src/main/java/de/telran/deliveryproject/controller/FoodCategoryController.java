package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.CategoryFood;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.service.interfaces.FoodCategoryService;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food_category")
@RequiredArgsConstructor
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;
    @GetMapping("/show_food_category/{foodCategoryId}")
    public CategoryFood showFoodCategoryById(@PathVariable String foodCategoryId){
        return foodCategoryService.showCategoryOfFood(foodCategoryId);
    }
}
