package com.mysql.data.mysqltry;

import com.mysql.data.mysqltry.model.User;
import com.mysql.data.mysqltry.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mysql.data.mysqltry"})
public class MysqltryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MysqltryApplication.class, args);

		// Using UserService methods
		UserService userService = context.getBean(UserService.class);
		User user = new User();
		user.setUsername("testUser");
		user.setPassword("testPassword");
		System.out.println(userService.registerUser(user));
		System.out.println(userService.loginUser(user));
	}
}