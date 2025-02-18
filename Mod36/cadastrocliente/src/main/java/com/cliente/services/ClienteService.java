package com.cliente.services;

import com.cliente.dao.ClienteDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.domain.Cliente;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    // private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        // this.clienteDAO = clienteDAO;
    }

    // @Override
    // public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException
    // {
    // return clienteDAO.cadastrar(cliente);
    // }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // @Override
    // public void excluir(Long cpf) {
    // clienteDAO.excluir(cpf);
    // }
    //
    // @Override
    // public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
    // clienteDAO.alterar(cliente);
    // }

}
