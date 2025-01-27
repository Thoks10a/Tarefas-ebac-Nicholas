package com.cliente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cliente.dao.ClienteDaoMock;
import com.cliente.dao.IClienteDAO;
import com.cliente.domain.Cliente;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.services.ClienteService;
import com.cliente.services.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarCPF(cliente.getCpf());
        // Assert.assertNotNull(clienteConsultado);
        Assert.assertEquals((Long) 5858l, clienteConsultado.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteService.alterar(cliente);

        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }

    // IClienteService clienteService;
    // Cliente cliente;

    // public ClienteServiceTest() {
    // IClienteDAO dao = new ClienteDaoMock();
    // clienteService = new ClienteService(dao);
    // }

    // @Before
    // public void init() {
    // cliente = new Cliente();
    // cliente.setNome("Rodrigo");
    // cliente.setCpf(248576L);
    // cliente.setTel(23467L);
    // cliente.setEnd("Endereco");
    // cliente.setNumero(121);
    // cliente.setCidade("Cidade");
    // cliente.setEstado("Estado");
    // }

    // @Test
    // public void pesquisarCliente() {

    // Cliente clienteConsultado = clienteService.buscarCPF(cliente.getCpf());

    // Assert.assertNotNull(clienteConsultado);

    // Assert.assertEquals((Long) 248576l, clienteConsultado.getCpf());

    // }

    // @Test
    // public void salvarCliente() {
    // Boolean retorno = clienteService.salvar(cliente);
    // Assert.assertTrue(retorno);

    // }

    // @Test
    // public void excluirCliente() {
    // clienteService.excluir(cliente.getCpf());

    // }

    // @Test
    // public void alterarCliente() {
    // cliente.setNome("Rodrigo Pires");
    // clienteService.alterar(cliente);

    // Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    // }
}
