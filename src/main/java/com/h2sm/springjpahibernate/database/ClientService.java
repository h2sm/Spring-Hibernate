package com.h2sm.springjpahibernate.database;

import com.h2sm.springjpahibernate.entities.Client;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Optional<Client> findClientByID(int id) {
        return clientRepository.findById(id);
    }
    public void deleteClientByID(int id){
        clientRepository.deleteById(id);
    }
    public void addClient(String fullName, String passport, String phoneNumber, Date dateOfBirth){
        var c = new Client(fullName, passport,phoneNumber,dateOfBirth);
        clientRepository.saveAndFlush(c);
    }
    public void modifyClient(int id, String fullName, String passport, String phoneNumber, Date dateOfBirth){
        findClientByID(id).map(client -> {
            client.setFullName(fullName);
            client.setDate_of_birth(dateOfBirth);
            client.setPassport(passport);
            client.setPhoneNumber(phoneNumber);
            return client;
        });
    }

}
