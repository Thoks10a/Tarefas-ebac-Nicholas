/**
 * 
 */
package br.com.nicholas.ClienteServiceProfessor.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nicholas.ClienteServiceProfessor.domain.Cliente;

/**
 * @author nicholas
 *
 */
@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String>{

	Optional<Cliente> findByCpf(Long cpf);
}
