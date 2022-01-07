package com.gees.App.steps;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.gees.App.models.ProductModel;
import com.gees.App.repositories.ProductRepository;
import com.gees.App.util.DrinkTypes;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCreationSteps {

    private @Autowired ProductRepository repository;
    private ProductModel newProduct;
    private List<ProductModel> list = new ArrayList<>();
    
    @Given("a product of the {string} type called {string}, {string}, with an image {string}, it has a value of {string} or {string} points. We have {string} in our inventory")
    public void addProducts(String typeProduct, String product, String description, String urlImage, String value, String points, String inventory){
        newProduct = new ProductModel();
        newProduct.setProduct(product);
        newProduct.setDescription(description);
        newProduct.setUrlImage(urlImage);
        newProduct.setValue(Float.parseFloat(value));
        newProduct.setDots(Long.parseLong(points));
        newProduct.setInventory(Long.parseLong(inventory));
        newProduct.setTypeProduct(DrinkTypes.valueOf(typeProduct));
        repository.save(newProduct);
    }

    @When("customer searches on type {string} of product with name {string}")
    public void searchProduct(String typeProduct, String product) {
        list = repository.findAllByTypeProductAndProductContaining(DrinkTypes.valueOf(typeProduct), product);
    }

    @Then("{int} products should have been found")
    public void valid(int quantity) {
        assertEquals(quantity, list.size());
    }
}
