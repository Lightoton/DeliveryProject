package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Restaurant;
import de.telran.deliveryproject.service.interfaces.RestaurantService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/show_restaurant/{restaurantId}")
    public Restaurant showRestaurantById(@UuidChecker @PathVariable String restaurantId) {
        return restaurantService.showRestaurant(restaurantId);
    }

    @PostMapping("/add_restaurant_to_DB")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }
}
