package egd.covid.covidfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "egd.covid.persistence.repository" })
@EntityScan(basePackages = { "egd.covid.persistence.entity", "egd.covid.persistence.entity.table",
		"egd.covid.persistence.entity.catalogo" })
public class CovidfrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidfrontApplication.class, args);
	}

}
