package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.*;
import de.telran.deliveryproject.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/show_order/{orderId}")
    public Order showFoodById(@PathVariable String orderId){
        return orderService.showOrder(orderId);
    }

    @DeleteMapping("/delete_order/{orderId}")
    public void deleteOrderById(@PathVariable String orderId){
        orderService.deleteOrderById(orderId);
    }

    @PostMapping("/create_order/{restaurantId},{clientId},{supportManagerId},{departmentId},{courierId}")
    public Order createOrder(@RequestBody Order order,@PathVariable String restaurantId,@PathVariable String clientId,
                             @PathVariable String supportManagerId,@PathVariable String departmentId,
                             @PathVariable String courierId){
        return orderService.createOrder(order,restaurantId,clientId,supportManagerId,departmentId,courierId);
    }
}
