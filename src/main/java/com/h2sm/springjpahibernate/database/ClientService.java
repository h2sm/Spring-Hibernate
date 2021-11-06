package com.h2sm.springjpahibernate.database;

import com.h2sm.springjpahibernate.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Optional<Client> findClientByID(int id) {
        return clientRepository.findById(id);
    }
}
