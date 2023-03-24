# DiceAPI
Spring Boot Dice API

I have made 2 REST APIs which gives the Weather information of a particular location by its name using Spring Boot

# Structure of Application
Controller package: Contains 2 classes 
1) WeatherController.java: which is a rest controller
2) WeatherService.java: service class which holds the business logic

Security package: contains security config class

Used the latest Spring Boot 3.0 secuirty features to implement the basic Authorization Mechanism

for accessing the APIs
Username: dice
Password: dice123

Sample Requests:

1) API 1: Get the Weather forecast summary of Any city using API (RapidApiGetForecastSummaryByLocationName)

    Request: GET localhost:8080/forecastsummarys/{cityName}
   
    Ex: GET localhost:8080/forecastsummarys/Berlin
 
   
2) API 2: Get hourly Weather forecast details of Any city using API (RapidApiGetHourlyForecastByLocationName)

   Request: GET localhost:8080/forecasthourlys/{cityName}
   
   Ex: GET localhost:8080/forecasthourlys/Berlin

The APIs are working.Let me know if you face any issues:

