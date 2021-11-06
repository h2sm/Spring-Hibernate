package com.h2sm.springjpahibernate.database;

import com.h2sm.springjpahibernate.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public Optional<Client> findClientByID(int id) {
        return clientRepository.findById(id);
    }
}
