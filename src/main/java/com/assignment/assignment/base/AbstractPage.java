package com.assignment.assignment.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {


    public static void navigate(final String url) {
        DriverFactory.getInstance().getDriver().navigate().to(url);
    }

    public static void enterText(By locator, String text) {
        DriverFactory.getInstance().getDriver().findElement(locator).sendKeys(text);
    }

    public static void click(By locator) {
        DriverFactory.getInstance().getDriver().findElement(locator).click();
    }

    public static void waitForAndClick(By locator) {
        waitFor(locator);
        DriverFactory.getInstance().getDriver().findElement(locator).click();
    }

    public static void waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static boolean checkWhetherAlreadySelected(By locator){
        return DriverFactory.getInstance().getDriver().findElement(locator).isSelected();
    }

    public static boolean checkWeatherElementIsPresent(By locator){
        return DriverFactory.getInstance().getDriver().findElement(locator).isDisplayed();
    }


}
