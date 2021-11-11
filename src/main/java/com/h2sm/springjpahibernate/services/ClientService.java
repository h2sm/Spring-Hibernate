package com.h2sm.springjpahibernate.services;

import com.h2sm.springjpahibernate.entities.Client;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {
    @Autowired
    private SessionFactory sessionFactory;
    public Optional<Client> findClientByID(int id) {

        var x = sessionFactory.getCurrentSession().get(Client.class, id);
        System.out.println(x);
        return null;
    }

    public void deleteClientByID(int id) {
    }

    public void addClient(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        var c = new Client(fullName, passport, phoneNumber, convert(dateOfBirth));
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
