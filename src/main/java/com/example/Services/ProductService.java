package com.example.Services;



import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Product; 

import java.util.List;

@Stateless
public class ProductService { 
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createProduct(Product product) { 
        entityManager.persist(product);
    }

    public Product getProductById(Integer productId) { 
        return entityManager.find(Product.class, productId);
    }

    public void updateProduct(Product product) { 
        entityManager.merge(product);
    }

    public void deleteProduct(Integer productId) { 
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public List<Product> getAllProducts() { // Изменено название метода и возвращаемого типа
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}
