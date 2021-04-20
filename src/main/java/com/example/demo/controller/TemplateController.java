package com.example.demo.controller;


import com.example.demo.Generic.controller.Controller;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.services.elasticSearch.impl.TemplateElasticSearchServiceImpl;
import com.example.demo.services.database.impl.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/templates")
public class TemplateController  {

    @Autowired
    private TemplateElasticSearchServiceImpl templateElasticSearchService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TemplateElasticSearch> getAll() {

        Iterable<TemplateElasticSearch> data = this.templateElasticSearchService.findAll();


        List<TemplateElasticSearch> actualList = StreamSupport
                .stream(data.spliterator(), false)
                .collect(Collectors.toList());
        return actualList;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<TemplateElasticSearch> getAllByCondition(@RequestParam("label") String label,
                                                               @RequestParam("template") String template,
                                                               @RequestParam("tempId") Long templateId){
        return null;


    }

}
