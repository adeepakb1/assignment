package com.assignment.assignment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.ThreadLocal.withInitial;

@Component("com.assignment.assignment.base.DriverFactory")

public class DriverFactory {

    //Logger logger = LoggerFactory.getLogger(this.getClass());

    DriverType selectedType = DriverType.CHROME;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

  //  private DriverFactory(){}

 //   private  DriverFactory instance = new DriverFactory();

   /* public  DriverFactory getInstance(){
        return instance;
    }*/

    ThreadLocal<WebDriver> driver = withInitial(() -> selectedType.getWebDriverObject(desiredCapabilities));

    public WebDriver getDriver(){
        return driver.get();
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
