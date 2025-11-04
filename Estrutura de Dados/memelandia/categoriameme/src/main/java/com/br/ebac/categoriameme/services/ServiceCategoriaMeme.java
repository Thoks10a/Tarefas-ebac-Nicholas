package com.br.ebac.categoriameme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ebac.categoriameme.entities.CategoriaMeme;
import com.br.ebac.categoriameme.repositories.RepositorioCategoriaMeme;

@Service
public class ServiceCategoriaMeme {

    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }

    public String TestePrint() {
        return "Teste de print";
    }
}
