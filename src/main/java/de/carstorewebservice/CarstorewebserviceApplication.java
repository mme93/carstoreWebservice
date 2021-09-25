package de.carstorewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CarstorewebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarstorewebserviceApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){	return new BCryptPasswordEncoder();	}

}
