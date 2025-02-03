package com.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.banco.domain.Produto;
import com.banco.domain.Cliente;
import com.banco.jdbc.dao.IProdutoDAO;
import com.banco.jdbc.dao.ProdutoDAO;

public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrar() throws Exception {
        produtoDAO = new ProdutoDAO(); // pega o produto

        Produto produto = new Produto(); // pega o Produto
        produto.setCodigo("5"); // seta o codigo do Produto
        produto.setNome("Carro2"); // seta o nome do Produto
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.buscar("5");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscar() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("5");
        produto.setNome("Carro");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.buscar("5");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void exclude() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        Produto produtoDB = produtoDAO.buscar("5");
        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluir() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("5");
        produto.setNome("Carro");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.buscar("5");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodos() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("5");
        produto.setNome("Carro");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtos = new Produto();
        produtos.setCodigo("20");
        produtos.setNome("Teste");
        Integer countCad2 = produtoDAO.cadastrar(produtos);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizar() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("5");
        produto.setNome("Carro");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro nome");
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.buscar("10");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
        }
    }
}
