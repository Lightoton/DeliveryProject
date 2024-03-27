package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.entity.Restaurant;
import de.telran.deliveryproject.service.interfaces.ClientService;
import de.telran.deliveryproject.service.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping("/show_restaurant/{restaurantId}")
    public Restaurant showRestaurantById(@PathVariable String restaurantId){
        return restaurantService.showRestaurant(restaurantId);
    }

    @PostMapping("/add_restaurant_to_DB")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.createRestaurant(restaurant);
    }
}
