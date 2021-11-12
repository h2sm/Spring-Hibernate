package com.h2sm.springjpahibernate.services.database;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    List<T> getAll();
    Optional<T> getByID(int id);
    void update(int id);
    void delete(int id);
    void save(T entity);
}