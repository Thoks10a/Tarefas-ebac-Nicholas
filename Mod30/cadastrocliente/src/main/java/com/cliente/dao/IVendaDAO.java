package com.cliente.dao;

import com.cliente.dao.generic.IGenericDAO;
import com.cliente.domain.Venda;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
