package com.assignment.assignment.page;


import com.assignment.assignment.base.AbstractPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NDTVPage extends AbstractPage {

    static Logger logger = LoggerFactory.getLogger(NDTVPage.class);

    public static void launchNDTVSearch() {
        navigate("https://www.ndtv.com/");
        logger.info("Launch ndtv home page " + Thread.currentThread().getId());
    }
    public static void closePopUp() {

    }
    public static void enterSearchTermAs(String text,By where) {
        enterText(where, text);
        logger.info("enter search term " + Thread.currentThread().getId());
    }

    public static void submit() {
        click(By.name("btnK"));
        logger.info("Google submit " + Thread.currentThread().getId());

    }


}
