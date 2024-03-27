package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.*;

public interface OrderService {
    Order showOrder(String id);

    Order createOrder(Order order, String restaurantId, String clientId, String supportManagerId,
                      String departmentId, String courierId);


    void deleteOrderById(String id);
}
