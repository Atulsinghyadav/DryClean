package com.cg.dryclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dryclean.entity.Services;

public interface ServiceRepo extends JpaRepository<Services, Integer> {

}
