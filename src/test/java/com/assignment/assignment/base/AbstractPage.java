package com.assignment.assignment.base;

import com.assignment.assignment.Properties.TestProperties;
import com.assignment.assignment.page.NDTVPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component("com.assignment.assignment.base.AbstractPage")
public  class AbstractPage implements Page{

    @Autowired
    DriverFactory driverFactory;

    @Autowired
    TestProperties testProperties;

    static Logger logger = LoggerFactory.getLogger(NDTVPage.class);

    public  void navigate(final String url) {
        driverFactory.getDriver().navigate().to(url);
    }

    public  void enterText(By locator, String text) {
        driverFactory.getDriver().findElement(locator).sendKeys(text);
    }

    public  void click(By locator) {
        driverFactory.getDriver().findElement(locator).click();
    }

    public  void waitForAndClick(By locator) {
        waitFor(locator);
        driverFactory.getDriver().findElement(locator).click();
    }

    public  void waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public  boolean checkWhetherAlreadySelected(By locator){
        return driverFactory.getDriver().findElement(locator).isSelected();
    }

    public  boolean checkWeatherElementIsPresent(By locator){
        return driverFactory.getDriver().findElement(locator).isDisplayed();
    }

    public  void launchNDTVSearch() {
        navigate(testProperties.getNDTVURL());
        logger.info("Launch ndtv home page " + Thread.currentThread().getId());
    }
    public  void closePopUp() {

    }
    public  void enterSearchTermAs(String text,By where) {
        enterText(where, text);
        logger.info("enter search term " + Thread.currentThread().getId());
    }

    public  void submit() {
        click(By.name("btnK"));
        logger.info("Google submit " + Thread.currentThread().getId());

    }


}
