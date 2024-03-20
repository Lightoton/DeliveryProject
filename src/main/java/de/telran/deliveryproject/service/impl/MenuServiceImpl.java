package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.exception.FoodNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.FoodRepository;
import de.telran.deliveryproject.repository.MenuRepository;
import de.telran.deliveryproject.service.interfaces.FoodService;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@Service
//@RequiredArgsConstructor
//public class MenuServiceImpl implements MenuService {
//    private final MenuRepository menuRepository;
//
//    @Override
//    public Menu showAllMenuByRestaurantTitle(String restaurantTitle) {
//        return menuRepository.findByR;
//    }
//}
