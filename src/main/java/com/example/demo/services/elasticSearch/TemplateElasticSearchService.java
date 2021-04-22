package com.example.demo.services.elasticSearch;

import com.example.demo.Generic.service.Service;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TemplateElasticSearchService extends Service<TemplateElasticSearch> {
    Page<TemplateElasticSearch> findAllByCondition(String template, int status, int currentPage, int pageSize);
}