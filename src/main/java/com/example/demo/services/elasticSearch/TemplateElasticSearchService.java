package com.example.demo.services.elasticSearch;

import com.example.demo.Generic.service.Service;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

public interface TemplateElasticSearchService<T> extends Service<T> {
        public  List <T> findAllByCondition(String label, String template, Long tempId);

}
