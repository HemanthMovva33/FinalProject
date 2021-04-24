package com.corporate.classifieds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.corporate.classifieds.entity.User;
import com.corporate.classifieds.repository.UserRepository;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CorporateApiGatewayApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CorporateApiGatewayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Nikhil", "$2y$12$B6I4IDz/WUqRn/9EWJPFFulwmNe6qC.ijNTR6VWSvV.C5yvTzbGXC", "ROLE_USER");
		userRepository.save(user1);
	}
}
