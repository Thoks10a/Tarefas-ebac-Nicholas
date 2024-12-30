package cadastro.clientes.com.dao;

import java.util.Collection;

import cadastro.clientes.com.domain.Cliente;

//Interface obrigatória

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();

}
