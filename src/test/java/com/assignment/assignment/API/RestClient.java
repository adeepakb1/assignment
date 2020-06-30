package com.assignment.assignment.API;


import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import java.util.Collections;
import java.util.Map;


public class RestClient {

    private RequestSpecification request;
    private String serviceName;

    public RequestSpecification service(String serviceName) {
        this.request = RestAssured.given();
        this.serviceName = serviceName;
        return request;
    }

    public RequestSpecification setHeaders(Map<String,String> headers){
        return this.request.headers(headers);

    }

    public RequestSpecification addQueryParams(Map<String,String> queryParams){
        return this.request.queryParams(queryParams);
    }

    public RequestSpecification addRequestBody(JsonObject jo){
        return this.request.body(jo.toString());
    }
    public RequestSpecification addRequestBody(Map body){
        return this.request.body(new JSONObject(body));
    }



}
