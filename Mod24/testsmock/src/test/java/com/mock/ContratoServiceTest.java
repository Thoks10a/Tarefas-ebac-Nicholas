package com.mock;

import org.junit.Assert;
import org.junit.Test;

import com.mock.dao.ContratoDao;
import com.mock.dao.IClienteDao;
import com.mock.dao.IContratoDao;
import com.mock.service.ContratoService;
import com.mock.service.IContratoService;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    // @Test(expected = UnsupportedOperationException.class)
    @Test
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    // TODO
    // Fazer métodos buscar, excluir e atualizar
    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();

        Assert.assertEquals("Busca", retorno);
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();

        Assert.assertEquals("Excluido", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();

        Assert.assertEquals("Atualizado", retorno);
    }

}
