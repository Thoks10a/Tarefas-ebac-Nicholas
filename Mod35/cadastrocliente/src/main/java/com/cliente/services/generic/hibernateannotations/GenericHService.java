package com.cliente.services.generic.hibernateannotations;

import java.io.Serializable;
import java.util.Collection;

import com.cliente.dao.Persistente;
import com.cliente.dao.generic.IGenericDaoH;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericHService<T extends Persistente, E extends Serializable>
        implements IGenericHService<T, E> {

    protected IGenericDaoH<T, E> dao;

    public GenericHService(IGenericDaoH<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
