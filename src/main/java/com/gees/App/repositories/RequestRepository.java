package com.gees.App.repositories;

import com.gees.App.models.RequestModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Inteface reponseble for inheriting crud methods
 * 
 * @author Boaz
 * @since 1.0
 * @see UserRepository
 * @see ProductRepository
 *
 */
@Repository
public interface RequestRepository extends JpaRepository<RequestModel, Long> {
    
}
