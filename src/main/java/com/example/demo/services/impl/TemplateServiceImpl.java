package com.example.demo.services.impl;

import com.example.demo.models.Template;
import com.example.demo.models.elasticSearchModels.TemplateElasticSearch;
import com.example.demo.repository.TemplateRepository;
import com.example.demo.repository.elasticSearch.TemplateElasticSearchRepo;
import com.example.demo.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService<Template> {

    @Autowired
    private TemplateRepository templateRepository;


    @Override
    public void save(Template template) {
        this.templateRepository.save(template);
    }

    @Override
    public Iterable<Template> findAll() {
        return this.templateRepository.findAll();
    }

    @Override
    public Template findById(Long id) {
        Optional<Template> template=this.templateRepository.findById(id);
        Template data = null;
        if (template.isPresent()){
           data=  template.get();
        }
        return data;
    }


    @Override
    public void saveAll(Iterable iterable) {

    }

    @Override
    public List<Template> getTemplateLimit() {
        return this.templateRepository.getTemplateLimit();
    }
}
