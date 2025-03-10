/**
 * 
 */
package br.com.wildtest.service;

import java.util.List;

import br.com.wildtest.domain.Produto;
import br.com.wildtest.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
