package com.airlinecompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineCompanyApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserRepository repository) {
//		return args -> {
//			Address address = new Address(
//					"15",
//					"ulica",
//					"78389",
//					"bp",
//					"srb"
//			);
//			//Address address2 = Address.builder().city("vlaja").country().build();
//			String email = "nakee.com";
//			User user = new User(
//					"jeca",
//					"pet",
//					"jecka",
//					"emaili.com",
//					"123",
//					address,
//					Role.ROLE_ADMIN
//			);

}
