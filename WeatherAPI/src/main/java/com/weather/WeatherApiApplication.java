package com.weather;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.weather.entity.DiceUser;
import com.weather.repository.UserRepository;

@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeatherApiApplication.class, args);
		
		UserRepository repository = context.getBean(UserRepository.class);
		
		List<DiceUser> lists = new ArrayList<>();
		
		lists.add(new DiceUser(1,"dice","dice123"));
		lists.add(new DiceUser(2,"aman","aman123"));
	
		repository.saveAll(lists);
	}

}
