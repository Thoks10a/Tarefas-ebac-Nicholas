package com.br.ebac.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.services.ServiceUsuario;

@RestController
@RequestMapping("/memelandia/usuario")
public class ControllerUsuario {

    @Autowired
    private ServiceUsuario serviceUsuario;
    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> buscaUsuarios() {
        return serviceUsuario.listaTodosUsuarios();
    }

    @PostMapping("/usuarios")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return serviceUsuario.novoUsuario(usuario);
    }
}
