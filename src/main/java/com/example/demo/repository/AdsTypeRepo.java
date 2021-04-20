package com.example.demo.repository;

import com.example.demo.models.AdsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsTypeRepo extends JpaRepository<AdsType, Long> {
}
