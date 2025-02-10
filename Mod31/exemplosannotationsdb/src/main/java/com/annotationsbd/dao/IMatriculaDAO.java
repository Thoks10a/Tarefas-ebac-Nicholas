package com.annotationsbd.dao;

import java.util.List;

import com.annotationsbd.domain.Curso;
import com.annotationsbd.domain.Matricula;

public interface IMatriculaDAO {
    Matricula cadastrar(Matricula mat);

    Matricula buscarPorCodigoCurso(String codigoCurso);

    Matricula buscarPorCurso(Curso curso);

    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    Matricula buscarPorCursoCriteria(Curso curso);

    List<Matricula> buscarTodos();

    void excluir(Matricula matricula);
}
