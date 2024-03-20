package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Courier;
import de.telran.deliveryproject.service.interfaces.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;
    @GetMapping("/show_courier/{courierId}")
    public Courier showCourierById(@PathVariable String courierId){
        return courierService.showCourier(courierId);
    }
    @GetMapping("/show_courier_by_name/{courierName}")
    public Courier showCourierByName(@PathVariable String courierName){
        return courierService.showCourierByName(courierName);
    }
    @GetMapping("/show_free_couriers")
    public Set<Courier> showFreeCouriers(){
        return courierService.showFreeCouriers();
    }
}
