package de.telran.deliveryproject.service.interfaces;

import de.telran.deliveryproject.entity.Client;

public interface ClientService {
    Client showClient(String id);

    Client updateClientById(String id, Client client);
}
