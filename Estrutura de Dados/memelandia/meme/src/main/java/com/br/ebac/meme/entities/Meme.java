package com.br.ebac.meme.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Meme {
    @Id
    private Long id;

    private String nome;

    private String descricao;

    private Date dataCadastro;

    public Meme() {}

    public Meme(Long id, String nome, String descricao, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
