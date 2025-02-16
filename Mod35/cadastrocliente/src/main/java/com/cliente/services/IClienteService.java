package com.cliente.services;

import com.cliente.domain.Cliente;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
    // Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    // Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    // void excluir(Long cliente);

    // void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
