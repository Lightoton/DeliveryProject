package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.SupportManager;
import de.telran.deliveryproject.exception.SupportManagerNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.SupportManagerRepository;
import de.telran.deliveryproject.service.interfaces.SupportManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupportManagerServiceImpl implements SupportManagerService {
    private final SupportManagerRepository supportManagerRepository;
    @Override
    public SupportManager showSupportManager(String id) {
        return supportManagerRepository.findById(UUID.fromString(id)).orElseThrow(()-> new SupportManagerNotFoundException(ErrorMessage.SUPPORT_MANAGER_NOT_FOUND));
    }
}
