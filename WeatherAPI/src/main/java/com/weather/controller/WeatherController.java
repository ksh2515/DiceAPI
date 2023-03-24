package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping(value = "/forecastsummarys/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> getWeatherSummary(@PathVariable String city) {

		if (city.isEmpty()) {
			return ResponseEntity.notFound().build();
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

}
