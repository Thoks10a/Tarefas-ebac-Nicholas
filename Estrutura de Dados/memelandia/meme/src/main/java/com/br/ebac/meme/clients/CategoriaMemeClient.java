package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoriaMemeClient", url = "http://localhost:8082/categoriameme")
public interface CategoriaMemeClient {

    
    @GetMapping("/todos-categoriamemes")
    List<CategoriaMemeDTO> buscaCategorias();

    @GetMapping("/id-categoria/{id}")
    CategoriaMemeDTO buscaCategoriaPorId(@PathVariable Long id);

    @GetMapping("/conexao-categoriameme")
    String ConexaoCategoriaMeme();

    @PostMapping("/cadastrar-categoria")
    CategoriaMemeDTO novaCategoria(@RequestBody CategoriaMemeDTO categoriaMemeDTO);
}
