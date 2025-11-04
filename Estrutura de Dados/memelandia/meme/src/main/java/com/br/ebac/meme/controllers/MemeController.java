package com.br.ebac.meme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.services.ServiceMeme;
import com.br.ebac.meme.clients.CategoriaMemeClient;

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    private ServiceMeme serviceMeme;
    @Autowired
    private CategoriaMemeClient categoriaMemeClient;
    public MemeController(ServiceMeme serviceMeme) {
        this.serviceMeme = serviceMeme;
    }

    @GetMapping("/todos-memes")
    public List<Meme> buscaMemes() {
        return serviceMeme.listaTodosMemes();
    }

    @GetMapping("/teste-print")
    public String testePrint() {
        return categoriaMemeClient.testePrint();
    }

    @PostMapping("")
    public Meme novoMeme(@RequestBody Meme meme) {
        return serviceMeme.novoMeme(meme);
    }
}
