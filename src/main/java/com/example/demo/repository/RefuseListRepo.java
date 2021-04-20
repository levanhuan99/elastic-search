package com.example.demo.repository;

import com.example.demo.models.RefuseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RefuseListRepo extends JpaRepository<RefuseList, Long> {

    @Query( value = "select * from refuse_list where label is not null", nativeQuery = true)
    Collection<RefuseList> getAllByLabel();
}
