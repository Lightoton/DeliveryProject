package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.service.interfaces.ClientService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @GetMapping("/show_client/{clientId}")
    public Client showClientById(@UuidChecker @PathVariable String clientId){
        return clientService.showClient(clientId);
    }
}
