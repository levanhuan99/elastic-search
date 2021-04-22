package com.example.demo.repository.elasticSearch;

import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateElasticSearchRepo extends ElasticsearchRepository<TemplateElasticSearch,Long> {


     Page<TemplateElasticSearch> findAllByTemplateContentAndStatus(String temp, int status, PageRequest pageRequest);
}
