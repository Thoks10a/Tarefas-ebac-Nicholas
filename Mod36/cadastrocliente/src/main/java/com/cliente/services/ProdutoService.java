package com.cliente.services;

import com.cliente.dao.IProdutoDAO;
import com.cliente.domain.Produto;
import com.cliente.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
