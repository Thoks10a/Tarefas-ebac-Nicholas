package com.cliente;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cliente.dao.ClienteDAO;
import com.cliente.dao.ClienteDaoMock;
import com.cliente.dao.IClienteDAO;
import com.cliente.domain.Cliente;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoTest {

    IClienteDAO clienteDao;
    Cliente cliente;

    public ClienteDaoTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setNome("Rodrigo");
        cliente.setCpf(248576L);
        cliente.setTel(23467L);
        cliente.setEnd("Endereco");
        cliente.setNumero(121);
        cliente.setCidade("Cidade");
        cliente.setEstado("Estado");
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

        Assert.assertEquals((Long) 248576l, clienteConsultado.getCpf());

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {

        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }

}
