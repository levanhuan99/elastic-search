package com.example.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.demo.models.AdserTypeElasticSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdserTypeRepository extends ElasticsearchRepository<AdserTypeElasticSearch, Long> {


    List<AdserTypeElasticSearch> findByName(String name);
    List<AdserTypeElasticSearch> findAllByNameContaining(String name);

}
