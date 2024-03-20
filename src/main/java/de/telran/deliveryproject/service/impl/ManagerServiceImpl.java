package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Manager;
import de.telran.deliveryproject.exception.ManagerNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.ManagerRepository;
import de.telran.deliveryproject.service.interfaces.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    @Override
    public Manager showManager(String id) {
        return managerRepository.findById(UUID.fromString(id)).orElseThrow(()-> new ManagerNotFoundException(ErrorMessage.MANAGER_NOT_FOUND));
    }
}
