package de.telran.deliveryproject.controller;

import de.telran.deliveryproject.dto.ClientAfterRegistrationDto;
import de.telran.deliveryproject.dto.ClientDto;
import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.service.interfaces.ClientService;
import de.telran.deliveryproject.validation.annotation.UuidChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/show_client/{clientId}")
    public Client showClientById(@UuidChecker @PathVariable String clientId) {
        return clientService.showClient(clientId);
    }

    @PostMapping("/create_client")
    public ClientAfterRegistrationDto createClient(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

    @PutMapping("/update_client/{clientId}")
    public Client updateClientById(@UuidChecker @PathVariable String clientId, @RequestBody Client client) {
        return clientService.updateClientById(clientId, client);
    }
}
