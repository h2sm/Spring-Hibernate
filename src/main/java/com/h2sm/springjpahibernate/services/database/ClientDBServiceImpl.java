package com.h2sm.springjpahibernate.services.database;

import com.h2sm.springjpahibernate.services.functionality.UpdateFunction;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.h2sm.springjpahibernate.entities.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientDBServiceImpl implements ServiceInterface<Client> {
    private UpdateFunction func = new UpdateFunction();
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Client> getByID(int id) {
        var session = sessionFactory.openSession();
        var client = session.get(Client.class, id);
        session.close();
        return Optional.ofNullable(client);
    }

    @Override
    public void update(int id) {
        var clientOptional  = getByID(id);
        if (clientOptional.isPresent()) {
            var client = UpdateFunction.updateClient(clientOptional.get());
            var session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(client);
            commitAndClose(session);
        }
    }

    @Override
    public void delete(int id) {
        var clientOptional = getByID(id);
        if (clientOptional.isPresent()){
            var client = clientOptional.get();
            var session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(client);
            commitAndClose(session);
        }
    }

    @Override
    public void save(Client entity) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        commitAndClose(session);
    }

    private void commitAndClose(Session s) {
        s.getTransaction().commit();
        s.close();
    }
}
