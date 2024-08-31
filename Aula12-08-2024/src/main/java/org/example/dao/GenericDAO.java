package org.example.dao;

import org.example.model.Entity;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();
    T getById(int id);
    void upsert(T entity);
    void delete(int id);
}