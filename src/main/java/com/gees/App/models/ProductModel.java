package com.gees.App.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gees.App.util.DrinkTypes;

/**
 * "tb_products" table abstraction. This columns is:
 * 
 * <p>
 * - idProduct: represents products id column. This column is automatically
 * generated
 * and AUTO_INCREMET;
 * </p>
 * <p>
 * - product: represents product name column. String;
 * </p>
 * <p>
 * - description: represents description product column. String;
 * </p>
 * <p>
 * - dots: represents dots column. Long;
 * </p>
 * <p>
 * - urlImage: represents image product column. String;
 * </p>
 * <p>
 * - inventory: represents inventory product column. Long;
 * </p>
 * <p>
 * - value: represents value product column. Float;
 * </p>
 * <p>
 * - typeProduct: represents type product column. ENUM DrinkTypes format
 * {DISTILLATES, ANISED, ALCOHOLICS, NON_ALCOHOLICS, BITTERS, BEERS, LIQUEURS,
 * WINES}.
 * </p>
 * 
 * @author Boaz
 * @since 1.0
 * @see RequestModel
 * @see UserModel
 * 
 */
@Entity
@Table(name = "tb_products")
public class ProductModel {

	// System generated Value
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduct;

	// Admin generated Values
	private String product;
	private String description;
	private Long dots;
	private String urlImage;
	private Long inventory;
	private Float value;
	private @Enumerated(EnumType.STRING) DrinkTypes typeProduct;

	// Getters and Setters
	public Long getIdProduct() {
		return idProduct;
	}

	public DrinkTypes getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(DrinkTypes typeProduct) {
		this.typeProduct = typeProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDots() {
		return dots;
	}

	public void setDots(Long dots) {
		this.dots = dots;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Long getInventory() {
		return inventory;
	}

	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
