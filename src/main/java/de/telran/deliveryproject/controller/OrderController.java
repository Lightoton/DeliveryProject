package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Order;
import de.telran.deliveryproject.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/show_order/{orderId}")
    public Order showFoodById(@PathVariable String orderId){
        return orderService.showOrder(orderId);
    }
}
