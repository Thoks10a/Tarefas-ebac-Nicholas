package com.br.ebac.categoriameme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ebac.categoriameme.entities.CategoriaMeme;
import com.br.ebac.categoriameme.services.ServiceCategoriaMeme;

@RestController
@RequestMapping("/categoriameme")
public class CategoriaMemeController {

    @Autowired
    private ServiceCategoriaMeme serviceCategoriaMeme;

    public CategoriaMemeController(ServiceCategoriaMeme serviceCategoriaMeme) {
        this.serviceCategoriaMeme = serviceCategoriaMeme;
    }

    @GetMapping("/todos-memes")
    public List<CategoriaMeme> buscaCategorias() {
        return serviceCategoriaMeme.listaTodasCategorias();
    }


    @PostMapping("")
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return serviceCategoriaMeme.novaCategoriaMeme(categoriaMeme);
    }
}