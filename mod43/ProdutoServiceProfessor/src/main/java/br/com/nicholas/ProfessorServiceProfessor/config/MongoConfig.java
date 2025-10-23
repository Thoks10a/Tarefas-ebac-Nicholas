/**
 * 
 */
package br.com.nicholas.ProfessorServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author nicholas
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.nicholas.ProdutoServiceProfessor.repository")
public class MongoConfig {

}
