package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Courier;
import de.telran.deliveryproject.exception.CourierNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.CourierRepository;
import de.telran.deliveryproject.service.interfaces.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;

    @Override
    public Courier showCourier(String id) {
        return courierRepository.findById(UUID.fromString(id)).orElseThrow(() -> new CourierNotFoundException(ErrorMessage.COURIER_NOT_FOUND));
    }

    @Override
    public Courier showCourierByName(String name) {
        return courierRepository.findByFirstName(name).orElseThrow(() -> new CourierNotFoundException(ErrorMessage.COURIER_NOT_FOUND));
    }

    @Override
    public Set<Courier> showFreeCouriers() {
        return courierRepository.findFreeCouriers();
    }
}
