package com.assignment.assignment.Properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("service")
@Component
public class TestProperties {
    private String baseURI;

    private String ndtvURI;

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public void setNdtvURI(String ndtvURI) {
        this.ndtvURI = ndtvURI;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public String getNDTVURL() {
        return ndtvURI;
    }
}
