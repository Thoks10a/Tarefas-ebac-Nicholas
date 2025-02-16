package com.cliente.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cliente.dao.generic.GenericDAO;
import com.cliente.domain.Estoque;

public class EstoqueDAO extends GenericDAO<Estoque, String> implements IEstoqueDAO {

    public EstoqueDAO() {
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(ID, CODIGO, NOME, QUANTIDADE)");
        sb.append("VALUES (nextval('sq_produto'),?,?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE CODIGO = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_ESTOQUE ");
        sb.append("SET CODIGO = ?,");
        sb.append("NOME = ?,");
        sb.append("QUANTIDADE = ?");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setInt(3, entity.getQuantidade());

    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
        stmDelete.setString(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setInt(3, entity.getQuantidade());
        stmUpdate.setString(4, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
        stmUpdate.setString(1, valor);
    }

}
