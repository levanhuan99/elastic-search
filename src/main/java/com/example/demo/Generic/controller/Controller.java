package com.example.demo.Generic.controller;

import java.util.List;

public interface Controller<T> {

    public List<T> getAll();

}
