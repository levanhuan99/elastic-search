package com.example.demo.services;

import java.util.List;


public interface UserService<T> {

    public List<T> processSearch(final String name);

    public T save(T t);

    public List<T> fetchUserName(final String name);

    public List<T> fetchUserByNameContaining(final String name);

    public void saveAll(Iterable i);
}
