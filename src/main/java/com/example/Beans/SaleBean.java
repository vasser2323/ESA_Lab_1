package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Sale;

@Stateless
public class SaleBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void addSale(Sale sale) {
        entityManager.persist(sale);
    }

    public void removeSale(Integer saleId) {
        Sale sale = entityManager.find(Sale.class, saleId);
        if (sale != null) {
            entityManager.remove(sale);
        }
    }

    public void updateSale(Sale sale) {
        entityManager.merge(sale);
    }

    public Sale findSaleById(Integer saleId) {
        return entityManager.find(Sale.class, saleId);
    }

    public List<Sale> getAllSales() {
        return entityManager.createQuery("SELECT s FROM Sale s", Sale.class).getResultList();
    }
}
