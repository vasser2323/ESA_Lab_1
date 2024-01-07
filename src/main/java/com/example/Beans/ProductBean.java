package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Product; // Обновленное имя сущности

@Stateless
public class ProductBean { // Обновленное имя класса

    @PersistenceContext
    private EntityManager entityManager;

    public void addProduct(Product product) { // Обновленное название метода и параметра
        entityManager.persist(product);
    }

    public void removeProduct(Integer productId) { // Обновленное название метода и параметра
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public void updateProduct(Product product) { // Обновленное название метода и параметра
        entityManager.merge(product);
    }

    public Product findProductById(Integer productId) { // Обновленное название метода и параметра
        return entityManager.find(Product.class, productId);
    }

    public List<Product> getAllProducts() { // Обновленное название метода и возвращаемого типа
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}
