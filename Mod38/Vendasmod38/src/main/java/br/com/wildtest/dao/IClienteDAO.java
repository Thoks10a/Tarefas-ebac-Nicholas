/**
 * 
 */
package br.com.wildtest.dao;

import java.util.List;

import br.com.wildtest.dao.generic.IGenericDAO;
import br.com.wildtest.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);

}
