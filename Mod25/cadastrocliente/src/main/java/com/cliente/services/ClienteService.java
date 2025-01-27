package com.cliente.services;

import com.cliente.dao.ClienteDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.domain.Cliente;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        // this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente buscarCPF(Long cpf) throws UnsupportedOperationException {
        // return clienteDAO.consultar(cpf);
        return this.consultar(cpf);
    }

    @Override
    public void excluir(Long cliente) {

    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {

    }

    // private IClienteDAO clienteDAO;

    // public ClienteService(IClienteDAO ClienteDAO) {
    // this.clienteDAO = ClienteDAO;
    // }

    // @Override
    // public Boolean salvar(Cliente cliente) {
    // return clienteDAO.salvar(cliente);
    // }

    // @Override
    // public Boolean cadastrar(Cliente cliente) throws
    // TipoChaveNaoEncontradaException {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    // }

    // @Override
    // public Cliente buscarCPF(Long cpf) {
    // return clienteDAO.buscarCPF(cpf);
    // }

    // @Override
    // public void excluir(Long cliente) {
    // clienteDAO.excluir(cliente);
    // }

    // @Override
    // public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    // }

}
