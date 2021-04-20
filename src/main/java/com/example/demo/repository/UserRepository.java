package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {


    List<User> findByName(String name);
    List<User> findAllByNameContaining(String name);
    List<User> findAllByNameAndFirstName(String name, String firstname);

}
