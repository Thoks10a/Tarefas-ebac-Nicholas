package com.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cliente.dao.ClienteDAO;
import com.cliente.dao.EstoqueDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.dao.IEstoqueDAO;
import com.cliente.dao.IProdutoDAO;
import com.cliente.dao.IVendaDAO;
import com.cliente.dao.ProdutoDAO;
import com.cliente.dao.VendaDAO;
import com.cliente.domain.Cliente;
import com.cliente.domain.Estoque;
import com.cliente.domain.Produto;
import com.cliente.domain.Venda;
import com.cliente.domain.Venda.Status;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;

public class EstoqueDaoTest {

    private IEstoqueDAO estoqueDAO;

    private IVendaDAO vendaDao;

    private IClienteDAO clienteDao;

    private IProdutoDAO produtoDao;

    private Cliente cliente;

    private Produto produto;

    public EstoqueDaoTest() {
        estoqueDAO = new EstoqueDAO();
        vendaDao = new VendaDAO();
        clienteDao = new ClienteDAO();
        produtoDao = new ProdutoDAO();

    }

    /*
     * @Before
     * public void init() throws TipoChaveNaoEncontradaException,
     * MaisDeUmRegistroException, TableException, DAOException {
     * this.cliente = cadastrarCliente();
     * this.produto = cadastrarProduto("A1", BigDecimal.TEN);
     * }
     */

    @After
    public void end() throws DAOException {
        excluirEstoque();
        excluirProdutos();
        clienteDao.excluir(this.cliente.getCpf());
    }

    private void excluirProdutos() throws DAOException {
        Collection<Produto> list = this.produtoDao.buscarTodos();
        for (Produto prod : list) {
            this.produtoDao.excluir(prod.getCodigo());
        }
    }

    private void excluirEstoque() throws DAOException {
        Collection<Estoque> list = this.estoqueDAO.buscarTodos();
        for (Estoque prod : list) {
            this.estoqueDAO.excluir(prod.getCodigo());
        }
    }

    private Estoque criarEstoque(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Estoque estoque = new Estoque();
        estoque.setCodigo(codigo);
        estoque.setNome("Produto 1");
        estoqueDAO.cadastrar(estoque);
        return estoque;
    }

    private void excluir(String valor) throws DAOException {
        this.estoqueDAO.excluir(valor);
    }

    @Test
    public void pesquisar()
            throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Estoque estoque = criarEstoque("A1");
        Assert.assertNotNull(estoque);
        Estoque estoqueBD = this.estoqueDAO.consultar(estoque.getCodigo());
        Assert.assertNotNull(estoqueBD);
        excluir(estoqueBD.getCodigo());
    }

    @Test
    public void salvar()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Venda venda = criarVenda("A2");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);

        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));

        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertTrue(vendaConsultada.getId() != null);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    private Venda criarVenda(String codigo) {
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setDataVenda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(Status.INICIADA);
        venda.adicionarProduto(this.produto, 2);
        return venda;
    }

    @Test
    public void excluir()
            throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Estoque estoque = criarEstoque("A3");
        Assert.assertNotNull(estoque);
        excluir(estoque.getCodigo());
        Estoque estoqueBD = this.estoqueDAO.consultar(estoque.getCodigo());
        assertNull(estoqueBD);
    }

    @Test
    public void alterarCliente()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Estoque estoque = criarEstoque("A4");
        estoque.setNome("Rodrigo Pires");
        estoqueDAO.alterar(estoque);
        Estoque estoqueBD = this.estoqueDAO.consultar(estoque.getCodigo());
        assertNotNull(estoqueBD);
        Assert.assertEquals("Rodrigo Pires", estoqueBD.getNome());

        excluir(estoque.getCodigo());
        Estoque estoqueBD1 = this.estoqueDAO.consultar(estoque.getCodigo());
        assertNull(estoqueBD1);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarEstoque("A5");
        criarEstoque("A6");
        Collection<Estoque> list = estoqueDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Estoque esto : list) {
            excluir(esto.getCodigo());
        }

        list = estoqueDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }

}
