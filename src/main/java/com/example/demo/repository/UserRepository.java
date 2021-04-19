package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.User;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {


    List<User> findByName(String name);
    List<User> findAllByNameContaining(String name);
    List<User> findAllByNameAndFirstName(String name, String firstname);

}
