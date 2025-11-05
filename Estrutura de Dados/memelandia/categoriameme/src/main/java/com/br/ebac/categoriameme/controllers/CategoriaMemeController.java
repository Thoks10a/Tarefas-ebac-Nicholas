package com.br.ebac.categoriameme.controllers;

import java.util.List;

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

    private ServiceCategoriaMeme serviceCategoriaMeme;

    public CategoriaMemeController(ServiceCategoriaMeme serviceCategoriaMeme) {
        this.serviceCategoriaMeme = serviceCategoriaMeme;
    }

    @GetMapping("/todos-categoriamemes")
    public List<CategoriaMeme> buscaCategorias() {
        return serviceCategoriaMeme.listaTodasCategorias();
    }

    @GetMapping("/conexao-categoriameme")
    public String ConexãoCategoriaMeme() {
        
        return serviceCategoriaMeme.ConexãoCategoriaMeme();
    }


    @PostMapping("")
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return serviceCategoriaMeme.novaCategoriaMeme(categoriaMeme);
    }
}