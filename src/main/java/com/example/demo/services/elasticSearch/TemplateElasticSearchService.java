package com.example.demo.services.elasticSearch;

import com.example.demo.Generic.service.Service;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;

import java.util.List;

public interface TemplateElasticSearchService extends Service<TemplateElasticSearch> {
    public List<TemplateElasticSearch> findAllByCondition( String template,int currentPage, int pageSize);
}
