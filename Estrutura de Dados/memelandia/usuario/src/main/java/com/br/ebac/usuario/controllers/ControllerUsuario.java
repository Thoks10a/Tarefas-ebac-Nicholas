package com.br.ebac.usuario.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.services.ServiceUsuario;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    private ServiceUsuario serviceUsuario;
    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping("/conexao-usuario")
    public String ConexaoUsuario() {
        return serviceUsuario.ConexaoUsuario();
    }


    @GetMapping("/usuarios")
    public List<Usuario> buscaUsuarios() {
        return serviceUsuario.listaTodosUsuarios();
    }

    @GetMapping("/id-usuario/{id}")
    public Usuario buscaUsuarioPorId(@PathVariable Long id) {
        return serviceUsuario.buscaUsuarioPorId(id);
    }

    @PostMapping("/cadastrar-usuario")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return serviceUsuario.novoUsuario(usuario);
    }
}
