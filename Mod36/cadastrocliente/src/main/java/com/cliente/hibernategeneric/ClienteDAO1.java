package com.cliente.hibernategeneric;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cliente.dao.IClienteDAODB;
import com.cliente.dao.generic.GenericDAO;
import com.cliente.dao.generic.GenericDaoDBH1;
import com.cliente.domain.Cliente;
import com.cliente.domain.ClienteH;

public class ClienteDAO1 extends GenericDaoDBH1<ClienteH, Long> implements IClienteDAODB<ClienteH> {

    public ClienteDAO1() {
        super(ClienteH.class);
    }

}
