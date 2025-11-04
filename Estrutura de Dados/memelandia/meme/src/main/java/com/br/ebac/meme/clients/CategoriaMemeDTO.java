package com.br.ebac.meme.clients;

import java.sql.Date;

public class CategoriaMemeDTO {

  private Long id;

  private String nome;

  private String descricao;

  private Date dataCadastro;

  public CategoriaMemeDTO() {}

  public CategoriaMemeDTO(Long id, String nome, String descricao, Date dataCadastro){
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
  
    @Override
  
    public String toString() {
  
      return "CategoriaMemeDTO{" +
  
          "id=" + id +
  
          ", nome='" + nome + '\'' +
  
          '}';
  
    }
}
