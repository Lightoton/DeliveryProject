package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.CategoryFood;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.exception.FoodCategoryNotFoundException;
import de.telran.deliveryproject.exception.FoodNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.FoodCategoryRepository;
import de.telran.deliveryproject.repository.FoodRepository;
import de.telran.deliveryproject.service.interfaces.FoodCategoryService;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    public CategoryFood showCategoryOfFood(String id) {
        return foodCategoryRepository.findById(UUID.fromString(id)).orElseThrow(()-> new FoodCategoryNotFoundException(ErrorMessage.FOOD_CATEGORY_NOT_FOUND));
    }
}
