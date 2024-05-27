package com.ui.uiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ui.uiapi.entity")
public class UiapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UiapiApplication.class, args);
	}
}

