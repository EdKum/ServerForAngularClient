package net.kum.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementBackendApplication.class, args);
	}
	
	@GetMapping("/api/hallo")
	public String hallo1() {
		return "hallo1";
	}
	
}

