/**
 * 
 */
package br.com.nicholas.ClienteServiceProfessor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author nicholas
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.nicholas.ClienteServiceProfessor.repository")
public class MongoConfig {

}
