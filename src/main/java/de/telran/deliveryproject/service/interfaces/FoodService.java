package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.Food;

import java.util.Set;

public interface FoodService {
    Food showFood(String id);
    Set<Food> showAllFoodsByMenuId(String id);
}
