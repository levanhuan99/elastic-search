package com.example.demo.Generic.service;

import java.util.List;

public interface Service<T> {

    void save(T t);

    Iterable<T> findAll();

    T findById(Long id);

    void saveAll(Iterable<T> iterable);



}
