package com.br.ebac.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ebac.usuario.entities.Usuario;


public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
