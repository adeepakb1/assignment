package com.assignment.assignment.stepdefs;

import com.assignment.assignment.API.RestController;
import com.assignment.assignment.AssignmentApplication;
import com.assignment.assignment.Exp.MatcherException;
import com.assignment.assignment.Weather.CityWeatherResponse;
import com.assignment.assignment.Weather.Variable;
import com.assignment.assignment.base.AbstractPage;
import com.assignment.assignment.base.DriverFactory;
import com.assignment.assignment.page.NDTVPage;
import com.google.gson.Gson;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;



public class MyStepdefs {

    static CityWeatherResponse city;
    static Logger logger = LoggerFactory.getLogger(MyStepdefs.class);
    static Map<String, String> infoFromUI;
    @Autowired
    NDTVPage ndtvPage;


    @Autowired
    RestController restController;

    @Autowired
    DriverFactory driverFactory;




    @Given("The User opens to ndtv page")
    public void theUserOpensToNdtvPage() {
        ndtvPage.launchNDTVSearch();
    }

    @And("User clicks on triple-dot to expand")
    public void userClicksOnTripleDotToExpand() {


        ndtvPage.click(By.id("h_sub_menu"));
        System.out.println();
    }

    @And("User clicks on {string}")
    public void userClicksOn(String textName) {
        ndtvPage.click(By.linkText(textName));
        System.out.println();
    }

    @And("User waits and clicks on {string}")
    public void userWaitsAndClicksOn(String arg0) {
        ndtvPage.waitForAndClick(By.linkText("No Thanks"));
    }

    @When("User lands on weather page")
    public void userLandsOnWeatherPage() {
        ndtvPage.waitFor(By.id("searchBox"));
        System.out.println("done");
    }

    @Then("User search my {string}")
    public void userSearchMy(String cityName) {
        ndtvPage.enterSearchTermAs(cityName, By.id("searchBox"));
        if (ndtvPage.checkWhetherAlreadySelected(By.id(cityName))) {

        } else {
            ndtvPage.click(By.xpath("//div[@id='messages']/div[65]/label"));
            System.out.println("");
        }
    }

    @Then("User sees the result {string} on screen")
    public void userSeesTheResultOnScreen(String cityName) {

        if (ndtvPage.checkWeatherElementIsPresent(By.xpath("//div[@id='map_canvas']/div/div[4]/div[9]/div/div[2]"))) {
            logger.info(cityName + " has been found on screen");

        } else {
            logger.error(cityName + " has not been found on screen");
        }

    }

    @When("User clicks on the selected {string}")
    public void userClicksOnTheSelected(String arg0) {
        ndtvPage.click(By.xpath("//div[@id='map_canvas']/div/div[4]/div[9]/div/div[2]"));
    }

    @Then("Weather information is shown")
    public void weatherInformationIsShown() {
        if (ndtvPage.checkWeatherElementIsPresent(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div"))) {
            logger.info("weather info has been found on screen");

        } else {
            logger.error("weather info has not been found on screen");
        }
        infoFromUI = new HashMap<>();

        String text = driverFactory.getDriver().findElement(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div/span/b")).getText();
        String text1 = driverFactory.getDriver().findElement(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div/span[2]/b")).getText();
        String text2 = driverFactory.getDriver().findElement(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div/span[3]/b")).getText();
        String text3 = driverFactory.getDriver().findElement(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div/span[4]/b")).getText();
        String text4 = driverFactory.getDriver().findElement(By.xpath("//div[@id='map_canvas']/div/div[6]/div/div/div/div/span[5]/b")).getText();

        infoFromUI.put("tempC", text3.split(":")[1].trim());
        infoFromUI.put("tempF", text4.split(":")[1].trim());
        infoFromUI.put("hum", text2.split(":")[1].trim().substring(0, 2));
        System.out.println("");

    }

    @And("I search the {string}")
    public void iSearchThe(String cityName) {
        //RestController restController = new RestController();
        Response response = restController.getWeatherDeatils(cityName);
        Gson gson = new Gson();
        city = gson.fromJson(response.asString(), CityWeatherResponse.class);
        System.out.println();
    }


    @Then("The information from two sources are compared")
    public void theInformationFromTwoSourcesAreCompared() {
        System.out.println();
        Variable t1 = new Variable();
        t1.setTemp(city.getMain().getFeelsLike());
        Variable t2 = new Variable();
        t2.setTemp(Double.parseDouble(infoFromUI.get("tempC") + ".0") + 273);
        Variable h1 = new Variable(), h2 = new Variable();
        h1.setTemp(city.getMain().getHumidity());
        h2.setTemp(Double.parseDouble(infoFromUI.get("hum") + ".0"));
        try {
            variance(t1, t2, 0.1);
            variance(h1,h2,0.15);
            logger.info("Variance test passed");
        } catch (MatcherException e) {
            logger.error("Variance test failed");
            e.printStackTrace();
        }
    }

    public static void variance(Variable f1, Variable f2, double var) throws MatcherException {
        boolean success = f2.getTemp() > f1.getTemp() - f1.getTemp() * var && f2.getTemp() < f1.getTemp() + f1.getTemp() * var;
        if (success) {

        } else {
            throw new MatcherException();
        }
    }


    @After
    public void closeDriver(){
        driverFactory.getDriver().close();
    }
}
