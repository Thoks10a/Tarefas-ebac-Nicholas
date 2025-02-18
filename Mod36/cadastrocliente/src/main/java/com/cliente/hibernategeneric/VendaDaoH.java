package com.cliente.hibernategeneric;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cliente.dao.generic.GenericDaoH;
import com.cliente.domain.ClienteH;
import com.cliente.domain.ProdutoH;
import com.cliente.domain.VendaH;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public class VendaDaoH extends GenericDaoH<VendaH, Long> implements IVendaDaoH {
    public VendaDaoH() {
        super(VendaH.class);
    }

    @Override
    public void finalizarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void cancelarVenda(VendaH venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void excluir(VendaH entity) throws DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaH cadastrar(VendaH entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            openConnection();
            entity.getProdutos().forEach(prod -> {
                ProdutoH prodJpa = entityManager.merge(prod.getProduto());
                prod.setProduto(prodJpa);
            });
            ClienteH cliente = entityManager.merge(entity.getCliente());
            entity.setCliente(cliente);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception e) {
            throw new DAOException("ERRO SALVANDO VENDA ", e);
        }

    }

    @Override
    public VendaH consultarComCollection(Long id) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendaH> query = builder.createQuery(VendaH.class);
        Root<VendaH> root = query.from(VendaH.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<VendaH> tpQuery = entityManager.createQuery(query);
        VendaH venda = tpQuery.getSingleResult();
        closeConnection();
        return venda;
    }
}
