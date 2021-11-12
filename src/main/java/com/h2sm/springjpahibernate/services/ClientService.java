package com.h2sm.springjpahibernate.services;

import com.h2sm.springjpahibernate.entities.Client;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.Session;
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

    private Session openSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session s) {
        s.close();
    }

    public <T> Optional<T> findClientByID(int id) {
        var s = openSession();
        var client = s.get(Client.class, id);
        closeSession(s);
        return Optional.of(client);
        //return client;
        // return sessionFactory.getCurrentSession().get(Client.class, id);
    }

    public void deleteClientByID(int id) {
        var s = openSession();
        s.beginTransaction();
        var client = findClientByID(id);
        s.delete(client);
        s.getTransaction().commit();
        closeSession(s);
    }

    public void addClient(String fullName, String passport, String phoneNumber, String dateOfBirth) {
        var client = new Client(fullName, passport, phoneNumber, convert(dateOfBirth));
        var session = openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        closeSession(session);
    }

    public void modifyClient(int id, String fullName, String passport, String phoneNumber, String dateOfBirth) {
        var client = findClientByID(id);

//        findClientByID(id).map(client -> {
//            client.setFullName(fullName);
//            client.setDate_of_birth(convert(dateOfBirth));
//            client.setPassport(passport);
//            client.setPhoneNumber(phoneNumber);
//            return client;
//        });
    }

    @SneakyThrows
    private Date convert(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        var date = formatter.parse(s);
        return new Date(date.getTime());
    }

}
