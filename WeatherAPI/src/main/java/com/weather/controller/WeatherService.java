package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.entity.AuthRequest;
import com.weather.service.CustomUserDetails;
import com.weather.service.WeatherService;
import com.weather.util.JwtUtil;

@RestController
public class WeatherController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private WeatherService weatherService;


	@PostMapping("/authenticate")
	private String generateToken(@RequestBody AuthRequest authRequest){

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@GetMapping(value = "/tests", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getTests() {

		String json = null;
		try {
			json = "this is a test case";
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(value = "/forecastsummarys/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getWeatherSummary(@PathVariable String city) {

		if (city.isEmpty() || city.equals(null)) {
			// throw new AttributeNotFoundException("city is Null");
			return ResponseEntity.noContent().build();
			// return ResponseEntity.notFound().build();
		}

		weatherService.setCity(city);
		String json = null;
		try {
			json = new String(weatherService.getWeatherSummary().toString());
			return ResponseEntity.ok(json);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(value = "/forecasthourlys/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getWeatherHourly(@PathVariable String city) {

		if (city.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		weatherService.setCity(city);
		String json = null;
		try {
			json = new String(weatherService.getWeatherHourly().toString());
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getWeatherSummary() {

		String json = null;
		try {
			json = new String(weatherService.getVersion().toString());
			return ResponseEntity.ok(json);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

}
