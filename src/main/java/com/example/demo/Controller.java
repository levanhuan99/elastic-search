package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.services.UserSearchServiceImpl;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/elastic-search/")
public class Controller {
    @Autowired
    private UserService userService;

    @Autowired
    private UserSearchServiceImpl userSearchService;



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> fetchData(@RequestParam(value = "q", required = false) String query) {
        List<User> users = this.userService.processSearch(query);
        System.out.println("ok");
        return users;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        User user1 = this.userService.createUserIndex(user);
        return  user1;
    }
}
