package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.services.impl.UserSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/elastic-search/")
public class Controller {

    @Autowired
    private UserSearchServiceImpl userSearchService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> fetchData(@RequestParam(value = "q", required = false) String query) {
        List<User> users = this.userSearchService.fetchUserByNameContaining(query);
        System.out.println("ok");
        return users;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody List<User> users) {
        Collection<User> collection = users;
        Iterable<User> iterable = collection;
        this.userSearchService.saveAll(iterable);
    }

}
