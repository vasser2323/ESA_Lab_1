package com.example.Services;



import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Product; // Изменен импорт на Product

import java.util.List;

@Stateless
public class ProductService { // Изменено название класса на ProductService
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createProduct(Product product) { // Изменено название метода и параметра
        entityManager.persist(product);
    }

    public Product getProductById(Integer productId) { // Изменено название метода и параметра
        return entityManager.find(Product.class, productId);
    }

    public void updateProduct(Product product) { // Изменено название метода и параметра
        entityManager.merge(product);
    }

    public void deleteProduct(Integer productId) { // Изменено название метода и параметра
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public List<Product> getAllProducts() { // Изменено название метода и возвращаемого типа
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}
