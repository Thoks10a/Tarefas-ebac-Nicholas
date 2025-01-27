package com.cliente.dao;

import com.cliente.dao.generic.GenericDAO;
import com.cliente.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    @Override
    public Class<Cliente> getTipoClasse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoClasse'");
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualiarDados'");
    }

    // @Override
    // public Boolean salvar(Cliente cliente) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    // }

    // @Override
    // public Cliente buscarCPF(Long cpf) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'buscarCPF'");
    // }

    // @Override
    // public void excluir(Long cliente) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    // }

    // @Override
    // public void alterar(Cliente cliente) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    // }

}
