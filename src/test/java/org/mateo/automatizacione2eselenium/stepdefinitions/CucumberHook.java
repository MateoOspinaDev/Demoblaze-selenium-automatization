package org.mateo.automatizacione2eselenium.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.mateo.automatizacione2eselenium.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @After
    public void down(){
        //driver.close();
        driver.quit();
    }

}
