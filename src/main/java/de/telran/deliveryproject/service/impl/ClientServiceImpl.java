package de.telran.deliveryproject.service.impl;

import de.telran.deliveryproject.dto.ClientAfterRegistrationDto;
import de.telran.deliveryproject.dto.ClientDto;
import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.entity.Department;
import de.telran.deliveryproject.exception.ClientNotFoundException;
import de.telran.deliveryproject.exception.errorMessege.ErrorMessage;
import de.telran.deliveryproject.generator.PasswordGenerator;
import de.telran.deliveryproject.mapper.ClientMapper;
import de.telran.deliveryproject.mapper.UserInfoMapper;
import de.telran.deliveryproject.repository.ClientRepository;
import de.telran.deliveryproject.repository.DepartmentRepository;
import de.telran.deliveryproject.repository.UserInfoRepository;
import de.telran.deliveryproject.service.interfaces.ClientService;
import de.telran.deliveryproject.utils.PasswordHashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final UserInfoRepository userInfoRepository;
    private final DepartmentRepository departmentRepository;
    private final ClientMapper mapper;


    @Override
    public Client showClient(String id) {
        return clientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));
    }

    @Override
    @Transactional
    public Client updateClientById(String id, Client client) {
        Client updateClient = clientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ClientNotFoundException(ErrorMessage.CLIENT_NOT_FOUND));
        updateClient.setAddress(client.getAddress());
        updateClient.setRating(client.getRating());
        return clientRepository.saveAndFlush(updateClient);
    }

    @Override
    @Transactional
    public ClientAfterRegistrationDto createClient(ClientDto clientDto) {
        Department department = departmentRepository.getReferenceById(UUID.fromString((clientDto.getDepartmentId())));
        Client client = mapper.toEntity(clientDto);
        if (client.getUserInfo().getPassword() == null || client.getUserInfo().getPassword().isEmpty()) {
            client.getUserInfo().setPassword(PasswordGenerator.generatePasswordBasedOnUUID());
        } else {
            String hashedPassword = PasswordHashing.hashPassword(client.getUserInfo().getPassword());
            client.getUserInfo().setPassword(hashedPassword);
        }
        client.setDepartment(department);
        userInfoRepository.save(client.getUserInfo());
        clientRepository.save(client);
        return mapper.toDto(client);
    }


}
