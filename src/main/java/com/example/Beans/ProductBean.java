package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Product;

@Stateless
public class ProductBean { 

    @PersistenceContext
    private EntityManager entityManager;

    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    public void removeProduct(Integer productId) { 
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public void updateProduct(Product product) { 
        entityManager.merge(product);
    }

    public Product findProductById(Integer productId) { 
        return entityManager.find(Product.class, productId);
    }

    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}
