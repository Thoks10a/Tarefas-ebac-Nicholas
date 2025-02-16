package com.cliente.Hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cliente.dao.VendaExclusaoHDao;
import com.cliente.domain.ClienteH;
import com.cliente.domain.ProdutoH;
import com.cliente.domain.VendaH;
import com.cliente.domain.VendaH.Status;
import com.cliente.exceptions.DAOException;
import com.cliente.exceptions.MaisDeUmRegistroException;
import com.cliente.exceptions.TableException;
import com.cliente.exceptions.TipoChaveNaoEncontradaException;
import com.cliente.hibernategeneric.ClienteDaoH;
import com.cliente.hibernategeneric.IClienteDaoH;
import com.cliente.hibernategeneric.IProdutoDaoH;
import com.cliente.hibernategeneric.IVendaDaoH;
import com.cliente.hibernategeneric.ProdutoDaoH;
import com.cliente.hibernategeneric.VendaDaoH;

public class VendaDaoHTest {
    private IVendaDaoH vendaDao;

    private IVendaDaoH vendaExclusaoDao;

    private IClienteDaoH clienteDao;

    private IProdutoDaoH produtoDao;

    private Random rd;

    private ClienteH cliente;

    private ProdutoH produto;

    public VendaDaoHTest() {
        this.vendaDao = new VendaDaoH();
        vendaExclusaoDao = new VendaExclusaoHDao();
        this.clienteDao = new ClienteDaoH();
        this.produtoDao = new ProdutoDaoH();
        rd = new Random();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("A1", BigDecimal.TEN);
    }

    @After
    public void end() throws DAOException {
        excluirVendas();
        excluirProdutos();
        clienteDao.excluir(this.cliente);
    }

    @Test
    public void pesquisar()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        VendaH venda = criarVenda("A1");
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        VendaH vendaConsultada = vendaDao.consultar(venda.getId());
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void salvar()
            throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        VendaH venda = criarVenda("A2");
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);

        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));

        VendaH vendaConsultada = vendaDao.consultar(venda.getId());
        assertTrue(vendaConsultada.getId() != null);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void cancelarVenda()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A3";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        retorno.setStatus(Status.CANCELADA);
        vendaDao.cancelarVenda(venda);

        VendaH vendaConsultada = vendaDao.consultar(venda.getId());
        assertEquals(codigoVenda, vendaConsultada.getCodigo());
        assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
    }

    @Test
    public void adicionarMaisProdutosDoMesmo()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A4";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(produto, 1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void adicionarMaisProdutosDiferentes()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A5";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoH prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        // TODO Usando este método apra evitar a exception
        // org.hibernate.LazyInitializationException
        // Ele busca todos os dados da lista pois a mesma por default é lazy
        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
    }

    @Test(expected = DAOException.class)
    public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
        VendaH venda = criarVenda("A6");
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);

        VendaH venda1 = criarVenda("A6");
        VendaH retorno1 = vendaDao.cadastrar(venda1);
        assertNull(retorno1);
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerProduto()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A7";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoH prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

        vendaConsultada.removerProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerApenasUmProduto()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A8";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoH prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

        vendaConsultada.removerProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerTodosProdutos()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A9";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoH prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

        vendaConsultada.removerTodosProdutos();
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
        assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.valueOf(0)));
        assertTrue(vendaConsultada.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void finalizarVenda()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A10";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        venda.setStatus(Status.CONCLUIDA);
        vendaDao.finalizarVenda(venda);

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutosVendaFinalizada()
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A11";
        VendaH venda = criarVenda(codigoVenda);
        VendaH retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        venda.setStatus(Status.CONCLUIDA);
        vendaDao.finalizarVenda(venda);

        VendaH vendaConsultada = vendaDao.consultarComCollection(venda.getId());
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());

        vendaConsultada.adicionarProduto(this.produto, 1);

    }

    private void excluirProdutos() throws DAOException {
        Collection<ProdutoH> list = this.produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                this.produtoDao.excluir(prod);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private void excluirVendas() throws DAOException {
        Collection<VendaH> list = this.vendaExclusaoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                this.vendaExclusaoDao.excluir(prod);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private ProdutoH cadastrarProduto(String codigo, BigDecimal valor)
            throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        ProdutoH produto = new ProdutoH();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(valor);
        produtoDao.cadastrar(produto);
        return produto;
    }

    private ClienteH cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        ClienteH cliente = new ClienteH();
        cliente.setCpf(rd.nextLong());
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        clienteDao.cadastrar(cliente);
        return cliente;
    }

    private VendaH criarVenda(String codigo) {
        VendaH venda = new VendaH();
        venda.setCodigo(codigo);
        venda.setDataVenda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(Status.INICIADA);
        venda.adicionarProduto(this.produto, 2);
        return venda;
    }
}
