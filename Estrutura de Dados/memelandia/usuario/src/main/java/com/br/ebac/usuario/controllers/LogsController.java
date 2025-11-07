package com.br.ebac.usuario.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.usuario.entities.Usuario;
import com.br.ebac.usuario.services.ServiceUsuario;


@RestController
@RequestMapping("/usuario-logs")
public class LogsController {

    private ServiceUsuario serviceUsuario;

    public LogsController(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping
    public ArrayList<Object> usuarioLog(Usuario usuario, String printUsuarioLogs){
        return serviceUsuario.usuarioLog(usuario, printUsuarioLogs);
    }
}
