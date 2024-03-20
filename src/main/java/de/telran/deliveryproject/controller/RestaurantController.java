package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.entity.Restaurant;
import de.telran.deliveryproject.service.interfaces.ClientService;
import de.telran.deliveryproject.service.interfaces.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
