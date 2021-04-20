package com.example.demo.services.elasticSearch.impl;

import com.example.demo.models.Template;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.repository.TemplateRepository;
import com.example.demo.repository.elasticSearch.TemplateElasticSearchRepo;
import com.example.demo.services.elasticSearch.TemplateElasticSearchService;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class TemplateElasticSearchServiceImpl implements TemplateElasticSearchService<TemplateElasticSearch> {

    @Autowired
    private TemplateElasticSearchRepo templateElasticSearchRepo;
//
//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public void save(TemplateElasticSearch templateElasticSearch) {

    }

    @Override
    public Iterable<TemplateElasticSearch> findAll() {
        return null;
    }

    @Override
    public TemplateElasticSearch findById(Long id) {
        return null;
    }

    @Override
    public void saveAll(Iterable<TemplateElasticSearch> iterable) {

    }

    @Override
    public List<TemplateElasticSearch>  findAllByCondition(String label, String template, Long tempId) {
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(matchQuery("title", template))
//                .build();
//        SearchHits<TemplateElasticSearch> userSearchHits = null;
        try {
//            userSearchHits = elasticsearchOperations.search(searchQuery, TemplateElasticSearch.class);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
