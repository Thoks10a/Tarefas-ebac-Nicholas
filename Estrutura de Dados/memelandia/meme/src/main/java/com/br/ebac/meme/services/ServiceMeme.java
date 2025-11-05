package com.br.ebac.meme.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ebac.meme.clients.CategoriaMemeClient;
import com.br.ebac.meme.clients.CategoriaMemeDTO;
import com.br.ebac.meme.clients.UsuarioClient;
import com.br.ebac.meme.clients.UsuarioDTO;
import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.repositories.RepositorioMeme;

@Service
public class ServiceMeme {

    private final CategoriaMemeClient categoriaMemeClient;
    private RepositorioMeme repositorioMeme;
    private UsuarioClient usuarioClient;
    public ServiceMeme(CategoriaMemeClient categoriaMemeClient, RepositorioMeme repositorioMeme, UsuarioClient usuarioClient) {
        this.categoriaMemeClient = categoriaMemeClient;
        this.repositorioMeme = repositorioMeme;
        this.usuarioClient = usuarioClient;
    }



    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public List<CategoriaMemeDTO> listaTodasCategorias() {
        return categoriaMemeClient.buscaCategorias();
    }

    public List<UsuarioDTO> listaTodosUsuarios() {
        return usuarioClient.buscaUsuarios();
    }

}
