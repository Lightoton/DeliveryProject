package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.entity.Restaurant;
import de.telran.deliveryproject.exception.RestaurantNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.RestaurantRepository;
import de.telran.deliveryproject.service.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant showRestaurant(String id) {
        return restaurantRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RestaurantNotFoundException(ErrorMessage.RESTAURANT_NOT_FOUND));
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {

        return restaurantRepository.saveAndFlush(restaurant);
    }

}
