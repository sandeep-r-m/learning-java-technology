package com.srm4knowledge.springdataelasticsearchexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = { "com.srm4knowledge.springdataelasticsearchexample.repositories" })
public class SpringDataElasticsearchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataElasticsearchExampleApplication.class, args);
	}

}
