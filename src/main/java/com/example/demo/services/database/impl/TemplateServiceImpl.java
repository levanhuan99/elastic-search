package com.example.demo.services.database.impl;

import com.example.demo.models.Template;
import com.example.demo.repository.database.TemplateRepository;
import com.example.demo.services.database.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Template> findByTemplateStatusAndTemplateContentContaining(int status, String temp, int currentPage, int pageSize) {
        return this.templateRepository.findTemplatesByStatusAndTemplateContentContaining(status,temp,PageRequest.of(currentPage,pageSize));
    }



}
