package com.compvision.demoCV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCvApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCvApplication.class, args);
		MainController.testFunctionality();
	}

}
