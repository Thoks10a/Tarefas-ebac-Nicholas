package com.annotationsbd.dao;

import java.util.List;

import com.annotationsbd.domain.Curso;

public interface ICursoDAO {

    public Curso cadastrar(Curso curso);

    public void excluir(Curso cur);

    public List<Curso> buscarTodos();
}
