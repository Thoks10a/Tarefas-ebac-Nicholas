package com.br.ebac.meme.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "categoriaMemeClient", url = "http://localhost:8082/categoriameme")
public interface CategoriaMemeClient {

    @GetMapping("/todos-memes")
    List<CategoriaMemeDTO> buscaCategorias();

    @RequestMapping(method = RequestMethod.GET, value = "/teste-print")
    String testePrint();
}
