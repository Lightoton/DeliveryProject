package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.dto.FoodDto;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.exception.FoodNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.mapper.FoodMapper;
import de.telran.deliveryproject.repository.FoodRepository;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper mapper;

    @Override
    @Transactional
    public FoodDto getFood(String id) {
        Optional<Food> food = foodRepository.findById(UUID.fromString(id));
        return mapper.toDto(food.orElseThrow(() -> new FoodNotFoundException(ErrorMessage.FOOD_NOT_FOUND)));
    }

    @Override
    public Food showFood(String id) {
        return foodRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new FoodNotFoundException(ErrorMessage.FOOD_NOT_FOUND));
    }

    @Override
    public Set<Food> showAllFoodsByMenuId(String id) {
        return foodRepository.findAllFoodsByMenuId(UUID.fromString(id));
    }

}
