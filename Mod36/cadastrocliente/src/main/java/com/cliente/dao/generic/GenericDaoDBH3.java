package com.cliente.dao.generic;

import java.io.Serializable;

import com.cliente.dao.Persistente;

public class GenericDaoDBH3<T extends Persistente, E extends Serializable> extends GenericDaoH<T, E> {
    public GenericDaoDBH3(Class<T> persistenteClass) {
        super(persistenteClass, "Mysql1");
    }
}
