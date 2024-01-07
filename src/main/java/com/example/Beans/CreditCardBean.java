package com.example.Beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import com.example.modules.CreditCard;

@Stateless
public class CreditCardBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void addCreditCard(CreditCard creditCard) {
        entityManager.persist(creditCard);
    }

    public void removeCreditCard(Integer cardId) {
        CreditCard creditCard = entityManager.find(CreditCard.class, cardId);
        if (creditCard != null) {
            entityManager.remove(creditCard);
        }
    }

    public void updateCreditCard(CreditCard creditCard) {
        entityManager.merge(creditCard);
    }

    // Метод для получения списка кредитных карт
    public List<CreditCard> getAllCreditCards() {
        return entityManager.createQuery("SELECT c FROM CreditCard c", CreditCard.class).getResultList();
    }

    public CreditCard findCreditCardById(Integer cardId) {
        return entityManager.find(CreditCard.class, cardId);
    }
}
