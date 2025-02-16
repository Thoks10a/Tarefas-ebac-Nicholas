package com.cliente.dao;

import com.cliente.dao.generic.GenericDaoH;
import com.cliente.domain.VendaH;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.hibernategeneric.IVendaDaoH;

public class VendaExclusaoHDao extends GenericDaoH<VendaH, Long> implements IVendaDaoH {
    public VendaExclusaoHDao() {
        super(VendaH.class);
    }

    @Override
    public void finalizarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaH consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }
}
