package com.br.ebac.usuario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.repositories.RepositorioUsuario;

@Service
public class ServiceUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ArrayList<Object> usuarioLogs = new ArrayList<>();
    
    public ServiceUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario buscaUsuarioPorId(Long id) {
        usuarioLog(repositorioUsuario.findById(id).get(), printUsuarioLogs());
        return repositorioUsuario.findById(id).get();
    }

    public ArrayList<Object> usuarioLog(Usuario usuario, String printUsuarioLogs){
        if(usuario.getId() != null){
            usuarioLogs.add(printUsuarioLogs);
            usuarioLogs.add(usuario);
        }
        return usuarioLogs;
    }

    public String printUsuarioLogs(){
        return "Log de Usuario";
    }

    public String ConexaoUsuario() {
        return "Teste de conexão efetuado com exito! Cliente Usuario funcionando corretamente!";
    }

}
