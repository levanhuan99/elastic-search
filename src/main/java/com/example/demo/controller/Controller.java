package com.example.demo.controller;

import com.example.demo.models.AdsType;
import com.example.demo.models.AdserTypeElasticSearch;
import com.example.demo.repository.AdsTypeRepo;
import com.example.demo.repository.RefuseListRepo;
import com.example.demo.services.impl.AdserTypeSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/elastic-search/")
public class Controller {

    @Autowired
    private AdserTypeSearchServiceImpl adserTypeSearchService;

    @Autowired
    private AdsTypeRepo adsTypeRepo;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<AdserTypeElasticSearch> fetchData() {
        Iterable<AdserTypeElasticSearch> users = this.adserTypeSearchService.findAll();
        System.out.println("ok");
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void createUser(@RequestBody List<AdserTypeElasticSearch> users) {
        Collection<AdserTypeElasticSearch> collection = users;
        Iterable<AdserTypeElasticSearch> iterable = collection;
        this.adserTypeSearchService.saveAll(iterable);
    }

    @RequestMapping(value = "/ads-type", method = RequestMethod.GET)
    public List<AdsType> listAll() {
        //get data from db
        List<AdsType> data = this.adsTypeRepo.findAll();

        //save to elastic search server to query
        this.adserTypeSearchService.saveAll(data);

        return data;
    }


}
