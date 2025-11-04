package com.br.ebac.meme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.br.ebac.meme.clients.CategoriaMemeDTO;
import com.br.ebac.meme.clients.CategoriaMemeClient;
import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.repositories.RepositorioMeme;

@Service
public class ServiceMeme {

    private final CategoriaMemeClient categoriaMemeClient;

    public ServiceMeme(CategoriaMemeClient categoriaMemeClient) {
        this.categoriaMemeClient = categoriaMemeClient;
    }

    @Autowired
    private RepositorioMeme repositorioMeme;


    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public List<CategoriaMemeDTO> listaTodasCategorias() {
        return categoriaMemeClient.buscaCategorias();
    }

    public String testePrint2() {
        return categoriaMemeClient.testePrint2();
    }
}
