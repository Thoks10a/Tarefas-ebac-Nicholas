package com.mock.service;

import com.mock.dao.IContratoDao;

public class ContratoService implements IContratoService {
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'buscar'");
        contratoDao.buscar();
        return "Busca";
    }

    @Override
    public String excluir() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'excluir'");
        contratoDao.excluir();
        return "Excluido";
    }

    @Override
    public String atualizar() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
        contratoDao.atualizar();
        return "Atualizado";
    }
}
