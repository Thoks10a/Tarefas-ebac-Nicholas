package com.br.ebac.usuario.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.repositories.RepositorioUsuario;

@Service
public class ServiceUsuario {

    private RepositorioUsuario repositorioUsuario;

    
    public ServiceUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public String ConexaoUsuario() {
        return "Teste de conexão efetuado com exito! Cliente Usuario funcionando corretamente!";
    }
}
