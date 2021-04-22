package com.example.demo.controller;


import com.example.demo.Generic.GeneralReponse.GeneralResponse;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.services.elasticSearch.Impl.TemplateElasticSearchServiceImpl;
import com.example.demo.services.database.impl.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/templates")
public class TemplateController {

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private TemplateElasticSearchServiceImpl templateElasticSearchService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<GeneralResponse<List<TemplateElasticSearch>>> getAll() {
        ResponseEntity responseEntity = null;
        GeneralResponse<List<TemplateElasticSearch>> generalResponse = new GeneralResponse();
        Iterable<TemplateElasticSearch> data = this.templateElasticSearchService.findAll();


        List<TemplateElasticSearch> actualList = StreamSupport
                .stream(data.spliterator(), false)
                .collect(Collectors.toList());

        generalResponse.setData(actualList);
        generalResponse.setCode(200);
        generalResponse.setMessage("successful");
        generalResponse.setTotalItem(actualList.size());
        Pageable sortedByName =
                PageRequest.of(0, 3, Sort.by("name"));
        responseEntity = new ResponseEntity(generalResponse, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<GeneralResponse<List<TemplateElasticSearch>>> getTemplateByCondition(@RequestParam("temp") String temp,
                                                                                               @RequestParam("currentPage") int currentPage,
                                                                                               @RequestParam("pageSize") int pageSize) {
        ResponseEntity responseEntity = null;
        GeneralResponse<List<TemplateElasticSearch>> generalResponse = new GeneralResponse();

        List<TemplateElasticSearch> templateElasticSearchList = this.templateElasticSearchService.findAllByCondition(temp,currentPage,pageSize);

        generalResponse.setData(templateElasticSearchList);
        generalResponse.setCode(200);
        generalResponse.setMessage("successful");
        generalResponse.setTotalItem(templateElasticSearchList.size());
        responseEntity = new ResponseEntity(generalResponse, HttpStatus.OK);

        return responseEntity;
    }


}
