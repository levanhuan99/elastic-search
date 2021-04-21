package com.example.demo.services.elasticSearch.Impl;

import com.example.demo.models.Template;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.repository.TemplateRepository;
import com.example.demo.repository.elasticSearch.TemplateElasticSearchRepo;
import com.example.demo.services.elasticSearch.TemplateElasticSearchService;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

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
    public List<TemplateElasticSearch> findAllByCondition(String template) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("templateContent", template)
                        .operator(Operator.OR)
                        .fuzziness(Fuzziness.ONE))
                .build();
        SearchHits<TemplateElasticSearch> userSearchHits = null;
        try {
            userSearchHits = elasticsearchOperations.search(searchQuery, TemplateElasticSearch.class, IndexCoordinates.of("template"));

        } catch (Exception e) {
            System.out.println(e);
        }
        List<SearchHit<TemplateElasticSearch>> ttem = userSearchHits.getSearchHits();
        List<TemplateElasticSearch> result = new ArrayList<>();
        for (int i = 0; i < ttem.size(); i++) {
            result.add(ttem.get(i).getContent());
        }
        return result;
    }
}
