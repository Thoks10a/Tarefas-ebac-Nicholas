package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UsuarioClient", url = "http://localhost:8083/usuario")
public interface UsuarioClient {

    @GetMapping("/conexao-usuario")
    String ConexaoUsuario();

    @GetMapping("/usuarios")
    List<UsuarioDTO> buscaUsuarios();
}
