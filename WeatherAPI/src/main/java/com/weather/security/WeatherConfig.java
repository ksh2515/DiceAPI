package com.weather.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WeatherConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		
		try {
			httpSecurity.csrf().disable()
			   .authorizeHttpRequests()
			   .requestMatchers("/forecastsummarys/**")
			   .permitAll()
			   .and()
			   .authorizeHttpRequests()
			   .requestMatchers("/forecasthourlys/**")
			   .permitAll()
			   .and()
			   .httpBasic()
			   .setBuilder(httpSecurity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	


}
