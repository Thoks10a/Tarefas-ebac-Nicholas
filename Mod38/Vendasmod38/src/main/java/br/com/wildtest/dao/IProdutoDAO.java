/**
 * 
 */
package br.com.wildtest.dao;

import java.util.List;

import br.com.wildtest.dao.generic.IGenericDAO;
import br.com.wildtest.domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
