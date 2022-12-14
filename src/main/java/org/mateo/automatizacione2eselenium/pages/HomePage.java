package org.mateo.automatizacione2eselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mateo.automatizacione2eselenium.driver.DriverFactory.getDriver;

public class HomePage {
    WebDriver getDriver= getDriver();

    @FindBy(id = "login2")
    public WebElement loginBanner;
    @FindBy(id = "logout2")
    public WebElement logoutBanner;
    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement home;
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[4]/a")
    public WebElement cart;

    public WebElement categoryMenu(String category){
        return getDriver.findElement(By.xpath("//a[text()='"+category+"']"));
    }

    public By ByProduct(String product){
        return By.xpath("//div[contains(@class,'card')]//a[text()='"+product+"']");
    }
}
