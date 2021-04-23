package com.example.demo.services.elasticSearch.impl;

import com.example.demo.models.Template;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.repository.database.TemplateRepository;
import com.example.demo.repository.elasticSearch.TemplateElasticSearchRepo;
import com.example.demo.services.elasticSearch.TemplateElasticSearchService;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
public class TemplateElasticSearchServiceImpl implements TemplateElasticSearchService {

    @Autowired
    private TemplateElasticSearchRepo templateElasticSearchRepo;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public void save(TemplateElasticSearch templateElasticSearch) {

    }

    @Override
    public Iterable<TemplateElasticSearch> findAll() {
        return this.templateElasticSearchRepo.findAll();

    }

    @Override
    public TemplateElasticSearch findById(Long id) {
        Optional<TemplateElasticSearch> templateElasticSearch = this.templateElasticSearchRepo.findById(id);
        TemplateElasticSearch data = null;
        if (templateElasticSearch.isPresent()) {
            data = templateElasticSearch.get();
        }
        return data;
    }

    @Override
    public void saveAll(Iterable<TemplateElasticSearch> iterable) {
        Iterable<Template> templates = this.templateRepository.findAll();
        this.templateElasticSearchRepo.saveAll(iterable);
    }

    public void saveAllData(Iterable templates) {
        this.templateElasticSearchRepo.saveAll(templates);
    }

    @Override
    public Page<TemplateElasticSearch> findAllByCondition(String template, int status, int currentPage, int pageSize) {


        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("templateContent", template));
//        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(currentPage, pageSize, Sort.by(new Sort.Order(Sort.Direction.DESC, "_score"))));


        Page<TemplateElasticSearch> templateElasticSearches = null;
        try {
            templateElasticSearches = this.templateElasticSearchRepo.search(nativeSearchQueryBuilder.build());

        } catch (Exception e) {
            System.out.println(e);
        }

        return templateElasticSearches;
//        String newTemp = template.replaceAll(" ","*");

//       return this.templateElasticSearchRepo.findAllByTemplateContentAndStatus(template, status,PageRequest.of(currentPage,pageSize));

    }

    @Override
    public SearchHits<TemplateElasticSearch> findByCondition1(String temp, int status, int currentPage, int pageSize) {
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withFilter(boolQuery().must(termQuery("templateContent", temp)))
//                .withPageable(PageRequest.of(currentPage, pageSize,Sort.by(new Sort.Order(Sort.Direction.DESC, "_score"))))
//                .withQuery(matchQuery("templateContent", temp)
//                        .operator(Operator.OR)
//                        .fuzziness(Fuzziness.ONE))
//                .build();

        Query searchQuery = new NativeSearchQueryBuilder()
                .withPageable(PageRequest.of(currentPage, pageSize,Sort.by(new Sort.Order(Sort.Direction.DESC, "_score"))))
                .withFilter(boolQuery().must(termQuery("templateContent", temp)))
                .build();
        SearchHits<TemplateElasticSearch> userSearchHits = null;
        try {
            userSearchHits = elasticsearchOperations.search(searchQuery, TemplateElasticSearch.class, IndexCoordinates.of("template"));

        }catch (Exception e) {
            System.out.println(e);
        }
        return  userSearchHits;

    }


}