package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Sale;

import java.util.List;

@Stateless
public class SaleService {
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createSale(Sale sale) {
        entityManager.persist(sale);
    }

    public Sale getSaleById(Integer saleId) {
        return entityManager.find(Sale.class, saleId);
    }

    public void updateSale(Sale sale) {
        entityManager.merge(sale);
    }

    public void deleteSale(Integer saleId) {
        Sale sale = entityManager.find(Sale.class, saleId);
        if (sale != null) {
            entityManager.remove(sale);
        }
    }

    public List<Sale> getAllSales() {
        return entityManager.createQuery("SELECT s FROM Sale s", Sale.class).getResultList();
    }
}
