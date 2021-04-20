package com.example.demo.repository;

import com.example.demo.models.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {

    @Query(value = "select * from template where template_id>366000 and status  is not null",nativeQuery = true)
    public List<Template> getTemplateLimit();


}
