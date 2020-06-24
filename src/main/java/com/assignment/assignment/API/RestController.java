package com.assignment.assignment.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestController extends RestClient {

    public Response getWeatherDeatils(String name) {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://api.openweathermap.org");
//= service("weather")
        request.queryParam("q", name).queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea");

        Response response = request.get("/data/2.5/weather");
        response.prettyPrint();
        return response;
    }
}
