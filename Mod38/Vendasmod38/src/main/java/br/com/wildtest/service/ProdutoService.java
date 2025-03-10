/**
 * 
 */
package br.com.wildtest.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.wildtest.dao.IProdutoDAO;
import br.com.wildtest.domain.Produto;
import br.com.wildtest.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
