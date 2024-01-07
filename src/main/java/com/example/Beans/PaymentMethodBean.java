package com.example.Beans;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.PaymentMethod; // Changed import to PaymentMethod entity

@Stateless
public class PaymentMethodBean { // Renamed class to PaymentMethodBean

    @PersistenceContext
    private EntityManager entityManager;

    public void addPaymentMethod(PaymentMethod paymentMethod) { // Renamed method to addPaymentMethod
        entityManager.persist(paymentMethod);
    }

    public void removePaymentMethod(Integer methodId) { // Renamed method to removePaymentMethod
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, methodId);
        if (paymentMethod != null) {
            entityManager.remove(paymentMethod);
        }
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) { // Renamed method to updatePaymentMethod
        entityManager.merge(paymentMethod);
    }

    public PaymentMethod findPaymentMethodById(Integer methodId) { // Renamed method to findPaymentMethodById
        return entityManager.find(PaymentMethod.class, methodId);
    }

    public List<PaymentMethod> getAllPaymentMethods() { // Renamed method to getAllPaymentMethods
        return entityManager.createQuery("SELECT p FROM PaymentMethod p", PaymentMethod.class).getResultList();
    }
}
