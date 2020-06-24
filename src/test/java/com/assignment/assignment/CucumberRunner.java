package com.assignment.assignment;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/",plugin = {"pretty",
        "json:target/cucumber-report.json"} )
public class CucumberRunner {
}

