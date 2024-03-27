package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.*;
import de.telran.deliveryproject.exception.*;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.*;
import de.telran.deliveryproject.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;
    private final RestaurantRepository restaurantRepository;
    private final ClientRepository clientRepository;
    private final SupportManagerRepository managerRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public Order showOrder(String id) {
        return orderRepository.findById(UUID.fromString(id)).orElseThrow(() -> new OrderNotFoundException(ErrorMessage.ORDER_NOT_FOUND));
    }

    @Override
    public Order createOrder(Order order, String restaurantId, String clientId, String supportManagerId,
                             String departmentId, String courierId) {
        Client client = clientRepository.findById(UUID.fromString(clientId)).orElseThrow(() -> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));
        Courier courier = courierRepository.findById(UUID.fromString(courierId)).orElseThrow(() -> new CourierNotFoundException(ErrorMessage.COURIER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(UUID.fromString(restaurantId)).orElseThrow(() -> new RestaurantNotFoundException(ErrorMessage.RESTAURANT_NOT_FOUND));
        SupportManager supportManager = managerRepository.findById(UUID.fromString(supportManagerId)).orElseThrow(() -> new SupportManagerNotFoundException(ErrorMessage.SUPPORT_MANAGER_NOT_FOUND));
        Department department = departmentRepository.findById(UUID.fromString(departmentId)).orElseThrow(() -> new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_NOT_FOUND));

        order.setCouriers(Collections.singleton(courier));
        order.setClient(client);
        order.setRestaurant(restaurant);
        order.setSupportManager(supportManager);
        order.setDepartment(department);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.saveAndFlush(order);
    }


    @Override
    public void deleteOrderById(String id) {
        orderRepository.deleteById(UUID.fromString(id));
    }
}
