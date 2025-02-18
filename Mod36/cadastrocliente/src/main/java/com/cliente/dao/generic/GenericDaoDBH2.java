package com.cliente.dao.generic;

import java.io.Serializable;

import com.cliente.dao.Persistente;

public class GenericDaoDBH2<T extends Persistente, E extends Serializable> extends GenericDaoH<T, E> {
    public GenericDaoDBH2(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre2");
    }
}
