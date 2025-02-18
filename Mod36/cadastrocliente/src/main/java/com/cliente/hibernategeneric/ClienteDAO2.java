package com.cliente.hibernategeneric;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cliente.dao.IClienteDAODB;
import com.cliente.dao.generic.GenericDAO;
import com.cliente.dao.generic.GenericDaoDBH1;
import com.cliente.dao.generic.GenericDaoDBH2;
import com.cliente.domain.Cliente;
import com.cliente.domain.ClienteH;

public class ClienteDAO2 extends GenericDaoDBH2<ClienteH, Long> implements IClienteDAODB<ClienteH> {

    public ClienteDAO2() {
        super(ClienteH.class);
    }

}
