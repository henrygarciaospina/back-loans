package com.loans.apploans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
@Configuration
public class AppLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppLoansApplication.class, args);
	}
}