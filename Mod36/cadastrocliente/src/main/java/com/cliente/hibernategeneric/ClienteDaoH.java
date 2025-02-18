package com.cliente.hibernategeneric;

import com.cliente.dao.generic.GenericDaoH;
import com.cliente.domain.ClienteH;

public class ClienteDaoH extends GenericDaoH<ClienteH, Long> implements IClienteDaoH {
    public ClienteDaoH() {
        super(ClienteH.class);
    }

}
