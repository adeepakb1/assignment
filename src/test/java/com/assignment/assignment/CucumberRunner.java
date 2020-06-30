package com.assignment.assignment;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(Cucumber.class)
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= AssignmentApplication.class)
@SpringBootTest
@CucumberOptions(features = "src/test/resources/features/",plugin = {"pretty",
        "json:target/cucumber-report.json"} )
public class CucumberRunner {
}

