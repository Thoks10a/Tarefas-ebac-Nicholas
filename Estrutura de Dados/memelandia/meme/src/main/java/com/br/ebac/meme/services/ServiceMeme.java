package com.br.ebac.meme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.repositories.RepositorioMeme;

@Component
public class ServiceMeme {

    @Autowired
    private RepositorioMeme repositorioMeme;


    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }
}
