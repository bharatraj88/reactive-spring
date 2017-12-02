package com.example.locationtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan( basePackages = {"entity"} )
@EnableMongoRepositories
public class ReactiveSpringLocationTrackingApp {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringLocationTrackingApp.class, args);
	}
}
