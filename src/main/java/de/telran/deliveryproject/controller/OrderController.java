package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Order;
import de.telran.deliveryproject.service.interfaces.OrderService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/show_order/{orderId}")
    public Order showFoodById(@UuidChecker @PathVariable String orderId) {
        return orderService.showOrder(orderId);
    }

    @DeleteMapping("/delete_order/{orderId}")
    public void deleteOrderById(@PathVariable String orderId) {
        orderService.deleteOrderById(orderId);
    }

    @PostMapping("/create_order/{restaurantId},{clientId},{supportManagerId},{departmentId},{courierId}")
    public Order createOrder(@RequestBody Order order,
                             @UuidChecker @PathVariable String restaurantId,
                             @UuidChecker @PathVariable String clientId,
                             @UuidChecker @PathVariable String supportManagerId,
                             @UuidChecker @PathVariable String departmentId,
                             @UuidChecker @PathVariable String courierId) {
        return orderService.createOrder(order, restaurantId, clientId, supportManagerId, departmentId, courierId);
    }
}
