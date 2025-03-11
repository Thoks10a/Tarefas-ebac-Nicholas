package com.testespring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testespring.domain.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
