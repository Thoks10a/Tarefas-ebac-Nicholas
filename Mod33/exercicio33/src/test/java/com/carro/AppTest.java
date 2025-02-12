package com.carro;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.carro.dao.AcessorioDao;
import com.carro.dao.CarroDao;
import com.carro.dao.IAcessorioDao;
import com.carro.dao.ICarroDao;
import com.carro.dao.IMarcaDao;
import com.carro.dao.MarcaDao;
import com.carro.domain.Acessorio;
import com.carro.domain.Carro;
import com.carro.domain.Marca;

public class AppTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public AppTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Carro carro = new Carro();
        carro.setCodigo("Dois");
        carro.setNome("Huracan");
        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    @Test
    public void cadastrarMarca() {
        Marca marca = new Marca();
        marca.setCodigo("Dois");
        marca.setValor(2000d);
        marca = marcaDao.cadastrar(marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }

    @Test
    public void cadastrarAcessorio() {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("Dois");
        acessorio.setDescricao("carro");
        acessorio = acessorioDao.cadastrar(acessorio);

        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());
    }

    @Test
    public void cadastrarGeral() {
        Carro carro = criarCarro("Dois");
        Marca marca = criarMarca("Dois");
        Acessorio acessorio = criarAcessorio("Dois");

        // marca.setCarro(carro);
        // marca.setAcessorio(acessorio);

        // carro.setMarca(marca);
        // marca = marcaDao.cadastrar(marca);

        // marca.setAcessorio(acessorio);
        acessorio = acessorioDao.cadastrar(acessorio);

        assertNotNull(marca);
        assertNotNull(marca.getId());

        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());

    }

    public Carro criarCarro(String codigo) {
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setNome("Huracan Lamborguini");
        carro = carroDao.cadastrar(carro);

        return carro;

    }

    public Marca criarMarca(String codigo) {
        Marca marca = new Marca();

        marca.setCodigo(codigo);
        marca.setValor(4000D);
        marca = marcaDao.cadastrar(marca);

        return marca;

    }

    public Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();

        acessorio.setCodigo(codigo);
        acessorio.setDescricao("carro bom");
        acessorio = acessorioDao.cadastrar(acessorio);

        return acessorio;

    }

}
