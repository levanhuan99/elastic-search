package com.example.demo.services.impl;

import com.example.demo.models.AdserTypeElasticSearch;
import com.example.demo.repository.AdserTypeRepository;
import com.example.demo.services.AdserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdserTypeSearchServiceImpl implements AdserTypeService<AdserTypeElasticSearch> {


    @Autowired
    private AdserTypeRepository adserTypeRepository;


    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<AdserTypeElasticSearch> fetchUserName(final String name) {
        return adserTypeRepository.findByName(name);
    }

    @Override
    public List<AdserTypeElasticSearch> fetchUserByNameContaining(final String name) {
        return adserTypeRepository.findAllByNameContaining(name);

    }


    @Override
    public List<AdserTypeElasticSearch> processSearch(final String name) {
        //1. Create query on multiple fields enabling fuzzy search
        Query searchQuery = new StringQuery("{\"match\":{\"name\":{\"query\":\"" + name + "\"}}}\"");


        //2. Execute search to get hits
        SearchHits<AdserTypeElasticSearch> userSearchHits = null;
        try {
            userSearchHits = elasticsearchOperations.search(searchQuery, AdserTypeElasticSearch.class);

        } catch (Exception e) {
            System.out.println(e);
        }

        //3. convert to return user list
        List<AdserTypeElasticSearch> usersMatch = new ArrayList<>();
        userSearchHits.forEach(userSearchHit -> {
            usersMatch.add(userSearchHit.getContent());
        });
        return usersMatch;
    }

    @Override
    public AdserTypeElasticSearch save(AdserTypeElasticSearch user) {
        return this.adserTypeRepository.save(user);
    }

    @Override
    public void saveAll(Iterable i) {
        this.adserTypeRepository.saveAll(i);
    }

    @Override
    public Iterable<AdserTypeElasticSearch> findAll() {
        return this.adserTypeRepository.findAll();
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
