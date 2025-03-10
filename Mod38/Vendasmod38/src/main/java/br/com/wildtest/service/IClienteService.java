/**
 * 
 */
package br.com.wildtest.service;

import java.util.List;

import br.com.wildtest.domain.Cliente;
import br.com.wildtest.exceptions.DAOException;
import br.com.wildtest.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
