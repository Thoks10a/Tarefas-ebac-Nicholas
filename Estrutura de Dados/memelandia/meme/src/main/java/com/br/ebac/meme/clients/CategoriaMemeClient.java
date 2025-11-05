package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "categoriaMemeClient", url = "http://localhost:8082/categoriameme")
public interface CategoriaMemeClient {

    
    @GetMapping("/todos-categoriamemes")
    List<CategoriaMemeDTO> buscaCategorias();

    @GetMapping("/conexao-categoriameme")
    String ConexaoCategoriaMeme();
}
