package com.cliente.hibernategeneric;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cliente.dao.IClienteDAODB;
import com.cliente.dao.generic.GenericDAO;
import com.cliente.dao.generic.GenericDaoDBH1;
import com.cliente.dao.generic.GenericDaoDBH3;
import com.cliente.domain.Cliente;
import com.cliente.domain.ClienteH;
import com.cliente.domain.ClienteH2;

public class ClienteDAO3 extends GenericDaoDBH3<ClienteH2, Long> implements IClienteDAODB<ClienteH2> {

    public ClienteDAO3() {
        super(ClienteH2.class);
    }

}
