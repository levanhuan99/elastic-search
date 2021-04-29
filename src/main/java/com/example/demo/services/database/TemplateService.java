package com.example.demo.services.database;

import com.example.demo.Generic.service.Service;
import com.example.demo.models.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TemplateService<Template> extends Service<Template> {

     List<Template> getTemplateLimit();


    Page<Template> findByTemplateStatusAndTemplateContentContaining(int status, String temp, int currentPage, int pageSize);
}
