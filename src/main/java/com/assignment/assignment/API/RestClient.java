package com.assignment.assignment.API;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class RestClient {

    private RequestSpecification request;
    private String serviceName;

    public RequestSpecification service(String serviceName) {
        this.request = RestAssured.given();
        this.serviceName = serviceName;
        return request;
    }



}
