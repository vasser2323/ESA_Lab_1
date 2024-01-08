package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.PaymentMethod; 

import java.util.List;

@Stateless
public class PaymentMethodService { 
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createPaymentMethod(PaymentMethod paymentMethod) { 
        entityManager.persist(paymentMethod);
    }

    public PaymentMethod getPaymentMethodById(Integer methodId) { 
        return entityManager.find(PaymentMethod.class, methodId);
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        entityManager.merge(paymentMethod);
    }

    public void deletePaymentMethod(Integer methodId) {
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, methodId);
        if (paymentMethod != null) {
            entityManager.remove(paymentMethod);
        }
    }

    public List<PaymentMethod> getAllPaymentMethods() { // Renamed method to getAllPaymentMethods
        return entityManager.createQuery("SELECT p FROM PaymentMethod p", PaymentMethod.class).getResultList();
    }
}
