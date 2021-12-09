package com.gees.App.repositories;

import com.gees.App.models.RequestModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel, Long> {
    
}
