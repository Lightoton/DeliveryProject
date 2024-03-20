package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.exception.ClientNotFoundException;
import de.telran.deliveryproject.exception.FoodNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.FoodRepository;
import de.telran.deliveryproject.service.interfaces.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    @Override
    public Food showFood(String id) {
        return foodRepository.findById(UUID.fromString(id)).orElseThrow(()-> new FoodNotFoundException(ErrorMessage.FOOD_NOT_FOUND));
    }
}
