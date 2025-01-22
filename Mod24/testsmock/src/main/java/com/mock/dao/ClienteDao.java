package com.mock.dao;

public class ClienteDao implements IClienteDao {
    public String salvar() {
        throw new NullPointerException("Não funciona sem config de banco");
        // return "Sucesso";
    }
}
