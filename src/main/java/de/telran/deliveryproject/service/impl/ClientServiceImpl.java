package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.exception.ClientNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.repository.ClientRepository;
import de.telran.deliveryproject.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client showClient(String id) {
        return clientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));
    }

    @Override
    public Client updateClientById(String id, Client client) {
        Client updateClient = clientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));
        updateClient.setAddress(client.getAddress());
        updateClient.setRating(client.getRating());
        return clientRepository.saveAndFlush(updateClient);
    }


}
