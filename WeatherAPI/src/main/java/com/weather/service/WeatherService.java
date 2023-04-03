package com.weather.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	private String cityName;

	public JSONObject getWeatherSummary() {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/" + getCity() + "/summary/"))
				.header("X-RapidAPI-Key", "29a9ce2905mshe73447e1d974e66p133081jsn08a3e2ff2985")
				.header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		JSONObject json = null;
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			json = new JSONObject(response.body().toString());
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return json;
	}

	public JSONObject getWeatherHourly() {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/" + getCity() + "/hourly/"))
				.header("X-RapidAPI-Key", "29a9ce2905mshe73447e1d974e66p133081jsn08a3e2ff2985")
				.header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		JSONObject json = null;
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			json = new JSONObject(response.body().toString());
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return json;
	}
	
	public JSONObject getVersion() {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://forecast9.p.rapidapi.com/"))
				.header("X-RapidAPI-Key", "29a9ce2905mshe73447e1d974e66p133081jsn08a3e2ff2985")
				.header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		JSONObject json = null;
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			json = new JSONObject(response.body().toString());
			return json;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return json;
		
	}

	public void setCity(String city) {
		this.cityName = city;
	}

	public String getCity() {
		return cityName;
	}

}
