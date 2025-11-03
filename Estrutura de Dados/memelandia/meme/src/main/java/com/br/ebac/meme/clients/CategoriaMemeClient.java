package com.br.ebac.meme.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "categoriaMemeClient", url = "http://localhost:8081/categoriameme")
public interface CategoriaMemeClient {


    @RequestMapping(method = RequestMethod.GET, value = "/todos-memes")
    List<CategoriaMeme> buscaCategorias();
}
