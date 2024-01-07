package com.example.Services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.example.modules.CreditCard; // Импортируйте правильный класс CreditCard

import java.util.List;

@Stateless
public class CreditCardService {
    
    @PersistenceContext(unitName="JavaEE")
    private EntityManager entityManager;
    
    public void createCreditCard(CreditCard creditCard) {
        entityManager.persist(creditCard);
    }

    public CreditCard getCreditCardById(Integer cardId) {
        return entityManager.find(CreditCard.class, cardId);
    }

    public void updateCreditCard(CreditCard creditCard) {
        entityManager.merge(creditCard);
    }

    public void deleteCreditCard(Integer cardId) {
        CreditCard creditCard = entityManager.find(CreditCard.class, cardId);
        if (creditCard != null) {
            entityManager.remove(creditCard);
        }
    }

    public List<CreditCard> getAllCreditCards() {
        return entityManager.createQuery("SELECT c FROM CreditCard c", CreditCard.class).getResultList();
    }

}
