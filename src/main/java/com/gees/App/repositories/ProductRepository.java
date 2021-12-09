package com.gees.App.repositories;

import java.util.List;

import com.gees.App.models.ProductModel;
import com.gees.App.util.DrinkTypes;

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

    /**
	 * Method used to search by typeProduct and product
	 * 
	 * @param typeProduct, DrinkTypes type
     * @param email, String type
	 * @return List<ProductModel>
	 * @author Boaz
	 * @since 1.0
	 * 
	 */
    List<ProductModel> findAllByTypeProductAndProductContaining(DrinkTypes typeProduct, String product);
    
}
