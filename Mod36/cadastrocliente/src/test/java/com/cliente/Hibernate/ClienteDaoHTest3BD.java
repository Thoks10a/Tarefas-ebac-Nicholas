package com.cliente.Hibernate;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cliente.dao.IClienteDAODB;
import com.cliente.domain.ClienteH;
import com.cliente.domain.ClienteH2;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.hibernategeneric.ClienteDAO1;
import com.cliente.hibernategeneric.ClienteDAO2;
import com.cliente.hibernategeneric.ClienteDAO3;
import com.cliente.hibernategeneric.ClienteDaoH;
import com.cliente.hibernategeneric.IClienteDaoH;

public class ClienteDaoHTest3BD {
    private IClienteDAODB<ClienteH> clienteDB1Dao;
    private IClienteDAODB<ClienteH> clienteDB2Dao;
    private IClienteDAODB<ClienteH2> clienteDB3Dao;

    private Random rd;

    public ClienteDaoHTest3BD() {
        this.clienteDB1Dao = new ClienteDAO1();
        this.clienteDB2Dao = new ClienteDAO2();
        this.clienteDB3Dao = new ClienteDAO3();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteH> list1 = clienteDB1Dao.buscarTodos();
        excluir1(list1);

        Collection<ClienteH> list2 = clienteDB2Dao.buscarTodos();
        excluir2(list2);
    }

    private void excluir1(Collection<ClienteH> list) {
        list.forEach(cli -> {
            try {
                clienteDB1Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluir2(Collection<ClienteH> list) {
        list.forEach(cli -> {
            try {
                clienteDB2Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteH cliente = criarCliente();
        clienteDB1Dao.cadastrar(cliente);

        ClienteH clienteConsultado = clienteDB1Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2Dao.cadastrar(cliente);

        ClienteH clienteConsultado2 = clienteDB2Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

    }

    @Test
    public void salvarCliente()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteH cliente = criarCliente();
        ClienteH retorno = clienteDB1Dao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteH clienteConsultado = clienteDB1Dao.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        // clienteDB1Dao.excluir(cliente);

        ClienteH clienteConsultado2 = clienteDB2Dao.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado2);
    }

    @Test
    public void excluirCliente()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteH cliente = criarCliente();
        ClienteH retorno = clienteDB1Dao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteH clienteConsultado = clienteDB1Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDB1Dao.excluir(cliente);
        clienteConsultado = clienteDB1Dao.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ClienteH cliente = criarCliente();
        ClienteH retorno = clienteDB1Dao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteH clienteConsultado = clienteDB1Dao.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDB1Dao.alterar(clienteConsultado);

        ClienteH clienteAlterado = clienteDB1Dao.consultar(clienteConsultado.getId());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDB1Dao.excluir(cliente);
        clienteConsultado = clienteDB1Dao.consultar(clienteAlterado.getId());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteH cliente = criarCliente();
        ClienteH retorno = clienteDB1Dao.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteH cliente1 = criarCliente();
        ClienteH retorno1 = clienteDB1Dao.cadastrar(cliente1);
        Assert.assertNotNull(retorno1);

        Collection<ClienteH> list = clienteDB1Dao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDB1Dao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<ClienteH> list1 = clienteDB1Dao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }

    private ClienteH criarCliente() {
        ClienteH cliente = new ClienteH();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        return cliente;
    }
}
