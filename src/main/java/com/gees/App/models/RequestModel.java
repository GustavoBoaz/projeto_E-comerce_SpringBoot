package com.gees.App.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gees.App.util.StatusRequest;

/**
 * "tb_requests" table abstraction. This columns is:
 * 
 * <p>
 * - idRequest: represents request id column. This column is automatically
 * generated and auto increment;
 * </p>
 * <p>
 * - status: represents status request column. ENUM StatusRequest format
 * {SCHEDULED, ROUTE, DELIVERED}. This column is automatically generated witch
 * value SCHEDULED;
 * </p>
 * <p>
 * - requestDate: Represents request date column. String format "yyyy-MM-dd".
 * This column is automatically generated;
 * </p>
 * <p>
 * - deliveryDate: Represents deadline date column. String format "yyyy-MM-dd".
 * This column is User generated;
 * </p>
 * <p>
 * - value: Represents value column. Float, this column is genereted from
 * servise in system;
 * </p>
 * 
 * @author Boaz
 * @since 1.0
 * @see UserModel
 * @see ProductModel
 * 
 */
@Entity
@Table(name = "tb_requests")
public class RequestModel {

    // System generated Value
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idRequest;
    private @Enumerated(EnumType.STRING) StatusRequest status = StatusRequest.SCHEDULED;
    private @JsonFormat(pattern = "yyyy-MM-dd") LocalDate requestDate = LocalDate.now();
    private Float value;

    // User generated Value
    private @JsonFormat(pattern = "yyyy-MM-dd") LocalDate deliveryDate;

    // Relations
    @ManyToOne
    @JoinColumn(name = "fk_buyer")
    private UserModel buyer;

    @OneToMany(orphanRemoval = false)
    @JoinColumn(name = "fk_product")
    private List<ProductModel> products = new ArrayList<>();

    // Getters and Setters
    public Long getIdRequest() {
        return idRequest;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public UserModel getBuyer() {
        return buyer;
    }

    public void setBuyer(UserModel buyer) {
        this.buyer = buyer;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public StatusRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRequest status) {
        this.status = status;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

}
