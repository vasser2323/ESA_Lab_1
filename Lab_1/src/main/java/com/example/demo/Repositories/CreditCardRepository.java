package com.example.demo.Repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import com.example.demo.models.CreditCard;

import java.util.ArrayList;
import java.util.List;


@Stateless
public class CreditCardRepository {
    @PersistenceContext(unitName = "LAB1")
    private EntityManager em;

    public List<CreditCard> findAll() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LAB1");
            em = emf.createEntityManager();
            return em.createQuery("SELECT c FROM \"CreditCard\" c", CreditCard.class).getResultList();
        } 
        return null;
    }

    public void persist(CreditCard entity) {
        em.persist(entity);
    }
}

