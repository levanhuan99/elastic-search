package com.example.demo.repository.elasticSearch;

import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateElasticSearchRepo extends ElasticsearchRepository<TemplateElasticSearch,Long> {

}
