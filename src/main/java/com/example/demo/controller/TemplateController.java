package com.example.demo.controller;


import com.example.demo.Generic.GeneralReponse.GeneralResponse;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.services.elasticSearch.impl.TemplateElasticSearchServiceImpl;
import com.example.demo.services.database.impl.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
                                                                                               @RequestParam("status") int status,
                                                                                               @RequestParam("currentPage") int currentPage,
                                                                                               @RequestParam("pageSize") int pageSize) {
        ResponseEntity responseEntity = null;
        GeneralResponse<List<TemplateElasticSearch>> generalResponse = new GeneralResponse();

        Page<TemplateElasticSearch> templateElasticSearchList = this.templateElasticSearchService.findAllByCondition(temp,status,currentPage,pageSize);


        generalResponse.setData(templateElasticSearchList.getContent());
        generalResponse.setCode(200);
        generalResponse.setMessage("successful");
        generalResponse.setTotalItem(templateElasticSearchList.getTotalElements());
        responseEntity = new ResponseEntity(generalResponse, HttpStatus.OK);

        return responseEntity;
    }


    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public ResponseEntity<GeneralResponse<List<TemplateElasticSearch>>> getTemplateByCondition1(@RequestParam("temp") String temp,
                                                                                               @RequestParam("status") int status,
                                                                                               @RequestParam("currentPage") int currentPage,
                                                                                               @RequestParam("pageSize") int pageSize) {
        ResponseEntity responseEntity = null;
        GeneralResponse<List<TemplateElasticSearch>> generalResponse = new GeneralResponse();

        SearchHits<TemplateElasticSearch>  templateElasticSearchList = this.templateElasticSearchService.findByCondition1(temp,status,currentPage,pageSize);

        List<SearchHit<TemplateElasticSearch>> ttem = templateElasticSearchList.getSearchHits();
        List<TemplateElasticSearch> data = new ArrayList<>();
        for (int i = 0; i < ttem.size(); i++) {
            data.add(ttem.get(i).getContent());
        }

        generalResponse.setData(data);
        generalResponse.setCode(200);
        generalResponse.setMessage("successful");
        generalResponse.setTotalItem(templateElasticSearchList.getTotalHits());


        responseEntity = new ResponseEntity(generalResponse, HttpStatus.OK);

        return responseEntity;
    }



    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public ResponseEntity<GeneralResponse<List<TemplateElasticSearch>>> getTemplateByLabel(@RequestParam("labelId") long labelId,
                                                                                               @RequestParam("currentPage") int currentPage,
                                                                                               @RequestParam("pageSize") int pageSize) {
        ResponseEntity responseEntity = null;
        GeneralResponse<List<TemplateElasticSearch>> generalResponse = new GeneralResponse();

        Page<TemplateElasticSearch> templateElasticSearchList = this.templateElasticSearchService.findAllByLabelId(labelId,currentPage,pageSize);

        generalResponse.setData(templateElasticSearchList.getContent());
        generalResponse.setCode(200);
        generalResponse.setMessage("successful");
        generalResponse.setTotalItem(templateElasticSearchList.getTotalElements());
        responseEntity = new ResponseEntity(generalResponse, HttpStatus.OK);

        return responseEntity;
    }




    private List<TemplateElasticSearch> convertSearchHitsToList(SearchHits<TemplateElasticSearch> searchHits){
                List<SearchHit<TemplateElasticSearch>> ttem = searchHits.getSearchHits();
        List<TemplateElasticSearch> result = new ArrayList<>();
        for (int i = 0; i < ttem.size(); i++) {
            result.add(ttem.get(i).getContent());
        }
        return  result;
    }

}