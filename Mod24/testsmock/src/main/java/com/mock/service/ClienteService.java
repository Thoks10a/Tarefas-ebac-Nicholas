package com.mock.service;

import com.mock.dao.ClienteDao;
import com.mock.dao.IClienteDao;

public class ClienteService {
    private IClienteDao clienteDao;
    // private ClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        // clienteDao = new ClienteDao();
        // clienteDao = new ClienteDaoMock();
        this.clienteDao = clienteDao;
    }

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }
}
