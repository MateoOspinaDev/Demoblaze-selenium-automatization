package org.mateo.automatizacione2eselenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.mateo.automatizacione2eselenium.utils.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Wait {
    public static void waiting(int seconds, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(),seconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitingBad() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitingLessBad(int seconds, WebElement webElement){
        WebDriverWait wait =  new WebDriverWait(getDriver(),seconds);
        WebElement element = wait.until(elementToBeClickable(webElement));
        getDriver().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }

}
