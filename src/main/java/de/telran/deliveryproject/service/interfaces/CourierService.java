package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.Courier;

import java.util.Set;

public interface CourierService {
    Courier showCourier(String id);
    Courier showCourierByName(String name);
    Set<Courier> showFreeCouriers();
}
