package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.elasticsearch.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


//    @Autowired
//    public UserSearchServiceImpl(UserRepository userRepository, ElasticsearchOperations elasticsearchOperations){
//        super();
//        this.userRepository = userRepository;
//        this.elasticsearchOperations = elasticsearchOperations;
//    }

    public List<User> fetchUserName(final String name) {
        return userRepository.findByName(name);
    }

    public List<User> fetchUserByNameContaining(final String name) {
        return userRepository.findAllByNameContaining(name);

    }

}
