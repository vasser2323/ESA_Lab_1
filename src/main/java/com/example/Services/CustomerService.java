package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.Customer; // Импорт вашего класса сущности Customer

import java.util.List;

@Stateless
public class CustomerService {

    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Integer customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    public void deleteCustomer(Integer customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
}
