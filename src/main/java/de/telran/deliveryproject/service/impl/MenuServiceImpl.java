package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Menu;
import de.telran.deliveryproject.exception.MenuNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.MenuRepository;
import de.telran.deliveryproject.service.interfaces.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    @Override
    public Menu showAllMenuById(String id) {
        return menuRepository.findById(UUID.fromString(id)).orElseThrow(() -> new MenuNotFoundException(ErrorMessage.MENU_NOT_FOUND));
    }
}
