package com.br.ebac.categoriameme.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ebac.categoriameme.entities.CategoriaMeme;
import com.br.ebac.categoriameme.repositories.RepositorioCategoriaMeme;

@Service
public class ServiceCategoriaMeme {

    private RepositorioCategoriaMeme repositorioCategoriaMeme;
    public ArrayList<Object> categoriaMemeLogs = new ArrayList<>();
    public ServiceCategoriaMeme(RepositorioCategoriaMeme repositorioCategoriaMeme) {
        this.repositorioCategoriaMeme = repositorioCategoriaMeme;
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        System.out.println("Buscando todas as categorias");
        return repositorioCategoriaMeme.findAll();
    }

    public CategoriaMeme buscaCategoriaPorId(Long id) {
        categoriaMemeLog(repositorioCategoriaMeme.findById(id).get(), printCategoriaMemeLogs());
        return repositorioCategoriaMeme.findById(id).get();
    }

    public ArrayList<Object> categoriaMemeLog(CategoriaMeme categoriaMeme, String printCategoriaMemeLogs){
        if(categoriaMeme.getId() != null){
            categoriaMemeLogs.add(printCategoriaMemeLogs);
            categoriaMemeLogs.add(categoriaMeme);
        }
        return categoriaMemeLogs;
    }

    public String printCategoriaMemeLogs(){
        return "Log de Categoria Meme";
    }

    public String ConexãoCategoriaMeme() {
        return "Teste de conexão efetuado com exito! Cliente CategoriaMeme funcionando corretamente!";
    }
}
