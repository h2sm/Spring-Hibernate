package com.h2sm.springjpahibernate.services;

import java.util.Optional;

public interface ServiceInterface<T> {
    Optional<T> getByID(int id);
    void update(T entity);
    void delete(T entity);
    void save(T entity);
}