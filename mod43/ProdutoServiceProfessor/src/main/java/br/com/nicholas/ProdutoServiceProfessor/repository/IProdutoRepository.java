/**
 * 
 */
package br.com.nicholas.ProdutoServiceProfessor.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nicholas.ProdutoServiceProfessor.domain.Produto;
import br.com.nicholas.ProdutoServiceProfessor.domain.Produto.Status;

/**
 * @author nicholas
 *
 */
@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String>{

	Optional<Produto> findByCodigo(String codigo);
	
	Page<Produto> findAllByStatus(Pageable pageable, Status status);
}
