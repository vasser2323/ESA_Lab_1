package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.PaymentMethod; // Assuming PaymentMethod entity

import java.util.List;

@Stateless
public class PaymentMethodService { // Renamed class to PaymentMethodService
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createPaymentMethod(PaymentMethod paymentMethod) { // Renamed method to createPaymentMethod
        entityManager.persist(paymentMethod);
    }

    public PaymentMethod getPaymentMethodById(Integer methodId) { // Renamed method to getPaymentMethodById
        return entityManager.find(PaymentMethod.class, methodId);
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) { // Renamed method to updatePaymentMethod
        entityManager.merge(paymentMethod);
    }

    public void deletePaymentMethod(Integer methodId) { // Renamed method to deletePaymentMethod
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, methodId);
        if (paymentMethod != null) {
            entityManager.remove(paymentMethod);
        }
    }

    public List<PaymentMethod> getAllPaymentMethods() { // Renamed method to getAllPaymentMethods
        return entityManager.createQuery("SELECT p FROM PaymentMethod p", PaymentMethod.class).getResultList();
    }
}