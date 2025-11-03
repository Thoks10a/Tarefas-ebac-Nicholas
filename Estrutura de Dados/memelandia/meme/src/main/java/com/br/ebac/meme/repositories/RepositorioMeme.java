package com.br.ebac.meme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ebac.meme.entities.Meme;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {

}
