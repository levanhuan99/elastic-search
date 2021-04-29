package com.example.demo.repository.database;

import com.example.demo.models.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {

    @Query(value = "select * from template where  status = 1 and contract_type_id =2 ",nativeQuery = true)
     List<Template> getTemplateLimit();

    Page<Template> findTemplatesByStatusAndTemplateContentContaining(int status, String temp,Pageable pageable);


}
