package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Saleproduct;

import java.util.List;

@Stateless
public class SaleproductService {

    @PersistenceContext(unitName = "JavaEE")
    private EntityManager entityManager;

    public void createSaleproduct(Saleproduct saleproduct) {
        entityManager.persist(saleproduct);
    }

    public Saleproduct getSaleproductById(Integer saleProductId) {
        return entityManager.find(Saleproduct.class, saleProductId);
    }

    public void updateSaleproduct(Saleproduct saleproduct) {
        entityManager.merge(saleproduct);
    }

    public void deleteSaleproduct(Integer saleProductId) {
        Saleproduct saleproduct = entityManager.find(Saleproduct.class, saleProductId);
        if (saleproduct != null) {
            entityManager.remove(saleproduct);
        }
    }

    public List<Saleproduct> getAllSaleproducts() {
        return entityManager.createQuery("SELECT sp FROM Saleproduct sp", Saleproduct.class).getResultList();
    }
}
