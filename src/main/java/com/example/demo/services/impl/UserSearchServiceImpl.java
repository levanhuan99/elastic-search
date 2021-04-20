package com.example.demo.services.impl;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchServiceImpl implements UserService<User> {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<User> fetchUserName(final String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> fetchUserByNameContaining(final String name) {
        return userRepository.findAllByNameContaining(name);

    }


    @Override
    public List<User> processSearch(final String name) {
        //1. Create query on multiple fields enabling fuzzy search
        Query searchQuery = new StringQuery("{\"match\":{\"name\":{\"query\":\"" + name + "\"}}}\"");


        //2. Execute search to get hits
        SearchHits<User> userSearchHits = null;
        try {
            userSearchHits = elasticsearchOperations.search(searchQuery, User.class);

        } catch (Exception e) {
            System.out.println(e);
        }

        //3. convert to return user list
        List<User> usersMatch = new ArrayList<>();
        userSearchHits.forEach(userSearchHit -> {
            usersMatch.add(userSearchHit.getContent());
        });
        return usersMatch;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void saveAll(Iterable i) {
        this.userRepository.saveAll(i);
    }

//    public List<IndexedObjectInformation> createUserIndexBulk(final List<User> users) {
//
//        List<IndexQuery> queries = users.stream()
//                .map(user ->
//                        new IndexQueryBuilder()
//                                .withId(user.getId().toString())
//                                .withObject(user).build())
//                .collect(Collectors.toList());
//
//        return elasticsearchOperations
//                .bulkIndex(queries, IndexCoordinates.of(USER_INDEX));
//    }
//
//
//    public User createUserIndex(User user) {
//
//        User user1 = this.userRepository.save(user);
//        return user1;
//
//    }
}
