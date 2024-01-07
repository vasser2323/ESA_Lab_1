package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Saleproduct;

@Stateless
public class SaleproductBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void addSaleProduct(Saleproduct saleProduct) {
        entityManager.persist(saleProduct);
    }

    public void removeSaleProduct(Integer saleProductId) {
        Saleproduct saleProduct = entityManager.find(Saleproduct.class, saleProductId);
        if (saleProduct != null) {
            entityManager.remove(saleProduct);
        }
    }

    public void updateSaleProduct(Saleproduct saleProduct) {
        entityManager.merge(saleProduct);
    }

    public Saleproduct findSaleProductById(Integer saleProductId) {
        return entityManager.find(Saleproduct.class, saleProductId);
    }

    public List<Saleproduct> getAllSaleProducts() {
        return entityManager.createQuery("SELECT sp FROM Saleproduct sp", Saleproduct.class).getResultList();
    }
}
