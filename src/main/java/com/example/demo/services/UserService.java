package com.example.demo.services;

import com.example.demo.models.User;

import com.example.demo.repository.UserRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String USER_INDEX = "user";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private UserRepository userRepository;


    public List<IndexedObjectInformation> createUserIndexBulk(final List<User> users) {

        List<IndexQuery> queries = users.stream()
                .map(user ->
                        new IndexQueryBuilder()
                                .withId(user.getId().toString())
                                .withObject(user).build())
                .collect(Collectors.toList());

        return elasticsearchOperations
                .bulkIndex(queries, IndexCoordinates.of(USER_INDEX));
    }


    public User createUserIndex(User user) {

        User user1 = this.userRepository.save(user);
        return user1;

    }


    public List<User> processSearch(final String name) {
        //1. Create query on multiple fields enabling fuzzy search
        Query searchQuery = new StringQuery("{\"match\":{\"name\":{\"query\":\"" + name + "\"}}}\"");
//        Query searchQuery = new NativeSearchQueryBuilder().withFilter(queryBuilder).build();

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

}
