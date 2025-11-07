package com.br.ebac.meme.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.ebac.meme.clients.CategoriaMemeClient;
import com.br.ebac.meme.clients.UsuarioClient;
import com.br.ebac.meme.entities.Meme;
import com.br.ebac.meme.repositories.RepositorioMeme;

@Service
public class ServiceMeme {

    private final CategoriaMemeClient categoriaMemeClient;
    private RepositorioMeme repositorioMeme;
    private UsuarioClient usuarioClient;
    ArrayList<Object> memeLogs = new ArrayList<>();
    public ServiceMeme(CategoriaMemeClient categoriaMemeClient, RepositorioMeme repositorioMeme, UsuarioClient usuarioClient) {
        this.categoriaMemeClient = categoriaMemeClient;
        this.repositorioMeme = repositorioMeme;
        this.usuarioClient = usuarioClient;
    }



    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public Meme buscaMemePorId(Long id){
        memeLog(repositorioMeme.findById(id).get(), printMemeLogs());
        return repositorioMeme.findById(id).get();
    }

    public ArrayList<Object> memeLog(Meme meme, String printMemeLogs){
        if(meme.getId() != null){
            memeLogs.add(printMemeLogs);
            memeLogs.add(meme);
        }
        return memeLogs;
    }

    public String printMemeLogs(){
        return "Log de Meme";
    }

}
