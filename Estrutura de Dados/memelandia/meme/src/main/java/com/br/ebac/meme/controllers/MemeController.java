package com.br.ebac.meme.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.meme.clients.CategoriaMemeClient;
import com.br.ebac.meme.clients.UsuarioClient;
import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.services.ServiceMeme;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private ServiceMeme serviceMeme;
    private CategoriaMemeClient categoriaMemeClient;
    private UsuarioClient usuarioClient;
    public MemeController(ServiceMeme serviceMeme, CategoriaMemeClient categoriaMemeClient, UsuarioClient usuarioClient) {
        this.serviceMeme = serviceMeme;
        this.categoriaMemeClient = categoriaMemeClient;
        this.usuarioClient = usuarioClient;
    }

    @GetMapping("/todos-memes")
    public List<Meme> buscaMemes() {
        return serviceMeme.listaTodosMemes();
    }

    @GetMapping("/conexao-categoriameme")
    public String ConexaoCategoriaMeme() {
        return categoriaMemeClient.ConexaoCategoriaMeme();
    }

    @GetMapping("/conexao-usuario")
    public String ConexaoUsuario() {
        return usuarioClient.ConexaoUsuario();
    }

    @PostMapping("")
    public Meme novoMeme(@RequestBody Meme meme) {
        return serviceMeme.novoMeme(meme);
    }
}
