package com.assignment.assignment.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public enum DriverType  implements DriverSetup{

    CHROME{
        @Override
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);

            ChromeOptions options = new ChromeOptions();
//            options.merge(desiredCapabilities);
//            options.setHeadless(HEADLESS);
            options.addArguments("--no-default-browser-check");
            options.setExperimentalOption("prefs", chromePreferences);

            return new ChromeDriver(options);
        }
    }


}
