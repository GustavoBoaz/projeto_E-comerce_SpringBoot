package com.gees.App.repositories;

import com.gees.App.models.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Inteface reponseble for inheriting crud methods
 * 
 * @author Boaz
 * @since 1.0
 * @see UserRepository
 * @see RequestRepository
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    
}
