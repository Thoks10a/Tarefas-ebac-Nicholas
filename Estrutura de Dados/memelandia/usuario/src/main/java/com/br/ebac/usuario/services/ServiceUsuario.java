package com.br.ebac.usuario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.repositories.RepositorioUsuario;

public class ServiceUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;


    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }
}
