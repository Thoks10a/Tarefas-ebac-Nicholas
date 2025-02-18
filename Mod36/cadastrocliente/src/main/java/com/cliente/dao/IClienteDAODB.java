package com.cliente.dao;

import com.cliente.dao.generic.IGenericDAO;
import com.cliente.dao.generic.IGenericDaoH;
import com.cliente.domain.Cliente;

public interface IClienteDAODB<T extends Persistente> extends IGenericDaoH<T, Long> {

    // Boolean salvar(Cliente cliente);

    // Cliente buscarCPF(Long cpf);

    // void excluir(Long cliente);

    // void alterar(Cliente cliente);
}
