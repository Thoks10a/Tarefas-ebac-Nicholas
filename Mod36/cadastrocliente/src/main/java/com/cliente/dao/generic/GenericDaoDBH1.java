package com.cliente.dao.generic;

import java.io.Serializable;

import com.cliente.dao.Persistente;

public class GenericDaoDBH1<T extends Persistente, E extends Serializable> extends GenericDaoH<T, E> {
    public GenericDaoDBH1(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre1");
    }
}
