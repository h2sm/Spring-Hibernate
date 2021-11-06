package com.h2sm.springjpahibernate.services;

import com.h2sm.springjpahibernate.database.ClientRepository;
import com.h2sm.springjpahibernate.entities.Client;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Optional<Client> findClientByID(int id) {
        return clientRepository.findById(id);
    }

    public void deleteClientByID(int id) {
        clientRepository.deleteById(id);
    }

    public void addClient(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        var c = new Client(fullName, passport, phoneNumber, convert(dateOfBirth));
        clientRepository.saveAndFlush(c);
    }

    public void modifyClient(int id, String fullName, String passport, String phoneNumber, String dateOfBirth) {
        findClientByID(id).map(client -> {
            client.setFullName(fullName);
            client.setDate_of_birth(convert(dateOfBirth));
            client.setPassport(passport);
            client.setPhoneNumber(phoneNumber);
            return client;
        });
    }

    @SneakyThrows
    private Date convert(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        var date = formatter.parse(s);
        return new Date(date.getTime());
    }

}
