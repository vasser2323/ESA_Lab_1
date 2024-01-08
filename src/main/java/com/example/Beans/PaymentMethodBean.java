package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.PaymentMethod; 

@Stateless
public class PaymentMethodBean { 

    @PersistenceContext
    private EntityManager entityManager;

    public void addPaymentMethod(PaymentMethod paymentMethod) { 
        entityManager.persist(paymentMethod);
    }

    public void removePaymentMethod(Integer methodId) {
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, methodId);
        if (paymentMethod != null) {
            entityManager.remove(paymentMethod);
        }
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        entityManager.merge(paymentMethod);
    }

    public PaymentMethod findPaymentMethodById(Integer methodId) { 
        return entityManager.find(PaymentMethod.class, methodId);
    }

    public List<PaymentMethod> getAllPaymentMethods() { 
        return entityManager.createQuery("SELECT p FROM PaymentMethod p", PaymentMethod.class).getResultList();
    }
}
