package de.carstorewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CarstorewebserviceApplication {
	@GetMapping("/")
	public String index() {
		return "Hallo ich bin ein SpringBoot";
	}
	public static void main(String[] args) {
		SpringApplication.run(CarstorewebserviceApplication.class, args);
	}

}
