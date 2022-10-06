package org.mateo.automatizacione2eselenium.utils;

import org.mateo.automatizacione2eselenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.mateo.automatizacione2eselenium.driver.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Wait {
    private static WebDriverWait webDriverWait;


    public static void waiting(WebElement webElement, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void waitingBad() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    public static WebDriverWait inCurrentBrowser(){
        webDriverWait = new WebDriverWait(DriverFactory.getDriver(), 10L);
        return webDriverWait;
    }



    public static void waitingGoodOrBad(int seconds, WebDriver driver, WebElement webElement){
        WebElement Espera=new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitingAlert(int seconds, WebDriver driver, WebElement webElement){
        //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    }

}
