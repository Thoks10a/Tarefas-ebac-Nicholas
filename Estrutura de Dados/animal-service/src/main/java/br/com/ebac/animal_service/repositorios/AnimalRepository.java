package br.com.ebac.animal_service.repositorios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ebac.animal_service.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{


    List<Animal> findByNomeProvisorio(String nomeProvisorio);
    List<Animal> findByRaca(String raca);
    List<Animal> findByDataEntrada(Date dataEntrada);
    List<Animal> findByDataAdocao(Date dataAdocao);
    List<Animal> findByCondicoesChegada(String condicoesChegada);
    List<Animal> findByNomeRecebedor(String nomeRecebedor);
    List<Animal> findByDataObito(Date dataObito);
    List<Animal> findByPorte(String porte);
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada DESC")
    List<Animal> findNotAdopted();
    @Query("SELECT nomeRecebedor,COUNT(nomeRecebedor) FROM Animal WHERE dataAdocao BETWEEN :timestamp AND :timestamp2 GROUP BY nomeRecebedor")
    List<Object[]> quantityAnimalsByAllEmployees(@Param("timestamp") Timestamp timestamp, @Param("timestamp2") Timestamp timestamp2);
    /*@NativeQuery("SELECT nome_recebedor,COUNT(nome_recebedor) FROM Animal WHERE data_adocao BETWEEN '2025-01-01'  AND '2025-12-31'  GROUP BY nome_recebedor")
    List<Animal> quantityAnimalsByAllEmployeesDB();*/

}
