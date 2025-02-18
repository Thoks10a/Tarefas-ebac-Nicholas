package com.cliente.hibernategeneric;

import com.cliente.dao.generic.GenericDaoH;
import com.cliente.domain.ProdutoH;

public class ProdutoDaoH extends GenericDaoH<ProdutoH, Long> implements IProdutoDaoH {
    public ProdutoDaoH() {
        super(ProdutoH.class);
    }
}
