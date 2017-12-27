package com.example.locationtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan( basePackages = {"entity"} )
@EnableMongoRepositories
public class NonReactiveSpringLocationTrackingApp {

	public static void main(String[] args) {
		SpringApplication.run(NonReactiveSpringLocationTrackingApp.class, args);
	}
}
