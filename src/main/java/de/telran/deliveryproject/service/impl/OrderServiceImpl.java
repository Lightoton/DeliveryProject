package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Order;
import de.telran.deliveryproject.exception.FoodNotFoundException;
import de.telran.deliveryproject.exception.OrderNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.FoodRepository;
import de.telran.deliveryproject.repository.OrderRepository;
import de.telran.deliveryproject.service.interfaces.FoodService;
import de.telran.deliveryproject.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public Order showOrder(String id) {
        return orderRepository.findById(UUID.fromString(id)).orElseThrow(() -> new OrderNotFoundException(ErrorMessage.ORDER_NOT_FOUND));
    }
}
