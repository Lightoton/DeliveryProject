package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.entity.Restaurant;

import java.util.Set;

public interface RestaurantService {
    Restaurant showRestaurant(String id);
    Restaurant createRestaurant(Restaurant restaurant);
}
