/**
 * 
 */
package br.com.nicholas.VendaServiceProfessor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nicholas.VendaServiceProfessor.domain.Venda;

/**
 * @author nicholas
 *
 */
@Repository
public interface IVendaRepository extends MongoRepository<Venda, String>{

	Optional<Venda> findByCodigo(String codigo);
}
