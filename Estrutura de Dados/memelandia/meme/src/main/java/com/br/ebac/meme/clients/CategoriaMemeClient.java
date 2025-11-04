package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "categoriaMemeClient", url = "http://localhost:8081/categoriameme")
public interface CategoriaMemeClient {


    @GetMapping("/teste-print2")
    String testePrint2();
    
    @GetMapping("/todos-memes")
    List<CategoriaMemeDTO> buscaCategorias();

    @GetMapping("/teste-print")
    String testePrint();
}
