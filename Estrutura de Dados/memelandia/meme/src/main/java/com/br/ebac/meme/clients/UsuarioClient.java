package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UsuarioClient", url = "http://localhost:8083/usuario")
public interface UsuarioClient {

    @GetMapping("/conexao-usuario")
    String ConexaoUsuario();

    @GetMapping("/usuarios")
    List<UsuarioDTO> buscaUsuarios();

    @GetMapping("/id-usuario/{id}")
    UsuarioDTO buscaUsuarioPorId(@PathVariable Long id);

    @PostMapping("/cadastrar-usuario")
    UsuarioDTO novoUsuario(@RequestBody UsuarioDTO usuarioDTO);

}
