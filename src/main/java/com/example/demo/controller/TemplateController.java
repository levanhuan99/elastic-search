package com.example.demo.controller;


import com.example.demo.Generic.controller.Controller;
import com.example.demo.models.Template;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.services.elasticSearchImpl.TemplateElasticSearchServiceImpl;
import com.example.demo.services.impl.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/templates")
public class TemplateController implements Controller<TemplateElasticSearch> {

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private TemplateElasticSearchServiceImpl templateElasticSearchService;

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TemplateElasticSearch> getAll() {

        Iterable<TemplateElasticSearch> data = this.templateElasticSearchService.findAll();


        List<TemplateElasticSearch> actualList = StreamSupport
                .stream(data.spliterator(), false)
                .collect(Collectors.toList());
        return actualList;
    }
}
