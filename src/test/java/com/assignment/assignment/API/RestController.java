package com.assignment.assignment.API;

import com.assignment.assignment.Properties.TestProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestController extends RestClient {

    @Autowired
    TestProperties testProperties;

    public Response getWeatherDeatils(String name) {

        RequestSpecification request = RestAssured.given();
        request.baseUri(testProperties.getBaseURI());
//= service("weather")
        request.queryParam("q", name).queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea");

        Response response = request.get("/data/2.5/weather");
        response.prettyPrint();
        return response;
    }
}
