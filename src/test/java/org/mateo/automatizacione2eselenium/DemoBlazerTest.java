package org.mateo.automatizacione2eselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazerTest {
    private  WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(); // Inicializa el navegador
        driver.manage().window().maximize(); // Maximiza la ventana
        driver.get("https://www.demoblaze.com/index.html"); // Abre la página
    }

    @Test
    public void authenticateTest() {
        WebElement login = driver.findElement(By.id("login2"));
        login.click();

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
