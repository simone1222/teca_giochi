package config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//dove abbiamo utilizzato due importanti annotazioni:
//− @EnableJpaRepositories
//indica a Spring Data JPA di cercare le repository class nel package specificato (repository), per iniettare il
//codice pertinente a tempo di esecuzione.
//− @EnableTransactionManagement
//indica a Spring Data JPA di generare il codice che si occupa della gestione delle transazioni a tempo di
//esecuzione.
//In questa classe, il 1° metodo crea un'istanza dell’EntityManagerFactory che deve gestire la persistence unit di
//nome SalesDB (nome specificato nel file persistence.xml di sopra).
//Il 2° metodo crea un'istanza del JpaTransactionManager da utilizzare insieme all’EntityManagerFactory
//creata dal 1° metodo. Questa è la configurazione minima richiesta, per l'utilizzo di Spring Data JPA.



@Configuration
@EnableJpaRepositories(basePackages = { "repository" })
@EnableTransactionManagement
public class JpaConfig {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("ConnectionDB");
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
