/**
 * 
 */
package br.com.nicholas.VendaServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author nicholas
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.nicholas.VendaServiceProfessor.repository")
public class MongoConfig {

}
