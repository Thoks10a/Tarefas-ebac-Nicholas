package com.carro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carro.domain.Marca;

public class MarcaDao implements IMarcaDao {

    @Override
    public Marca cadastrar(Marca marca) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicio33");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }

}
