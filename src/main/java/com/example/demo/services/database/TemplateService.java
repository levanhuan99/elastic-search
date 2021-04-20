package com.example.demo.services.database;

import com.example.demo.Generic.service.Service;
import com.example.demo.models.Template;

import java.util.List;

public interface TemplateService<Template> extends Service<Template> {

    public List<Template> getTemplateLimit();
}
