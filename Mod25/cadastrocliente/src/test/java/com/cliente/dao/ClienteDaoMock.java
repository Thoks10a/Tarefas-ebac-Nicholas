package com.cliente.dao;

import java.util.Collection;

import com.cliente.domain.Cliente;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    // @Override
    // public Boolean salvar(Cliente cliente) {

    // return true;
    // }

    // @Override
    // public Cliente buscarCPF(Long cpf) {
    // Cliente cliente = new Cliente();
    // cliente.setCpf(cpf);
    // return cliente;
    // }

    // @Override
    // public void excluir(Long cliente) {

    // }

    // @Override
    // public void alterar(Cliente cliente) {

    // }

}
