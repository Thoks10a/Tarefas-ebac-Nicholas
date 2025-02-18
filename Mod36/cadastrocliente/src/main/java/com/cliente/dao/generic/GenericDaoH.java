package com.cliente.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cliente.dao.Persistente;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public class GenericDaoH<T extends Persistente, E extends Serializable> implements IGenericDaoH<T, E> {

    // private static String PERSISTENCE_UNIT_NAME = "Postgre1";

    // protected EntityManagerFactory entityManagerFactory;

    // protected EntityManager entityManager;

    // private Class<T> persistenteClass;

    // public GenericDaoH(Class<T> persistenteClass, String persistenceUnitName) {
    // this.persistenteClass = persistenteClass;
    // this.PERSISTENCE_UNIT_NAME = persistenceUnitName;
    // }

    // public GenericDaoH(Class<T> persistenteClass) {
    // this.persistenteClass = persistenteClass;
    // }

    // @Override
    // public T cadastrar(T entity) throws TipoChaveNaoEncontradaException,
    // DAOException {
    // openConnection();
    // entityManager.persist(entity);
    // entityManager.getTransaction().commit();
    // closeConnection();
    // return entity;
    // }

    // @Override
    // public void excluir(T entity) throws DAOException {
    // openConnection();
    // entity = entityManager.merge(entity);
    // entityManager.remove(entity);
    // entityManager.getTransaction().commit();
    // closeConnection();
    // }

    // @Override
    // public T alterar(T entity) throws TipoChaveNaoEncontradaException,
    // DAOException {
    // openConnection();
    // entity = entityManager.merge(entity);
    // entityManager.getTransaction().commit();
    // closeConnection();
    // return entity;
    // }

    // @Override
    // public T consultar(E valor) throws MaisDeUmRegistroException, TableException,
    // DAOException {
    // openConnection();
    // T entity = entityManager.find(this.persistenteClass, valor);
    // entityManager.getTransaction().commit();
    // closeConnection();
    // return entity;
    // }

    // @Override
    // public Collection<T> buscarTodos() throws DAOException {
    // openConnection();
    // List<T> list = entityManager.createQuery(getSelectSql(),
    // this.persistenteClass).getResultList();
    // closeConnection();
    // return list;
    // }

    // protected void openConnection() {
    // entityManagerFactory =
    // Persistence.createEntityManagerFactory("cadastrocliente");
    // entityManager = entityManagerFactory.createEntityManager();
    // entityManager.getTransaction().begin();
    // }

    // protected void closeConnection() {
    // entityManager.close();
    // entityManagerFactory.close();
    // }

    // private String getSelectSql() {
    // StringBuilder sb = new StringBuilder();
    // sb.append("SELECT obj FROM ");
    // sb.append(this.persistenteClass.getSimpleName());
    // sb.append(" obj");
    // return sb.toString();
    // }

    private static final String PERSISTENCE_UNIT_NAME = "Postgre1";

    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    private Class<T> persistenteClass;

    private String persistenceUnitName;

    public GenericDaoH(Class<T> persistenteClass, String persistenceUnitName) {
        this.persistenteClass = persistenteClass;
        this.persistenceUnitName = persistenceUnitName;
    }

    public GenericDaoH(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        openConnection();
        T entity = entityManager.find(this.persistenteClass, valor);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        openConnection();
        List<T> list = entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        closeConnection();
        return list;
    }

    protected void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    protected void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT obj FROM ");
        sb.append(this.persistenteClass.getSimpleName());
        sb.append(" obj");
        return sb.toString();
    }

    private String getPersistenceUnitName() {
        if (persistenceUnitName != null
                && !"".equals(persistenceUnitName)) {
            return persistenceUnitName;
        } else {
            return PERSISTENCE_UNIT_NAME;
        }
    }

}
