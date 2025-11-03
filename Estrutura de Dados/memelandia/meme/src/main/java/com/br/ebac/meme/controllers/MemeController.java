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

@RestController
@RequestMapping("/meme")
public class MemeController {

    @Autowired
    private ServiceMeme serviceMeme;
    public MemeController(ServiceMeme serviceMeme) {
        this.serviceMeme = serviceMeme;
    }

    @GetMapping("/todos-memes")
    public List<Meme> buscaMemes() {
        return serviceMeme.listaTodosMemes();
    }

    @PostMapping("")
    public Meme novoMeme(@RequestBody Meme meme) {
        return serviceMeme.novoMeme(meme);
    }
}
