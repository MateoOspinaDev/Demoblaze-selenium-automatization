package org.mateo.automatizacione2eselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "loginusername")
    public WebElement username;
    @FindBy(id = "loginpassword")
    public WebElement password;
    @FindBy(xpath = "//*[@id=\"logInModal\"]//button[2]")
    public WebElement loginButton;
}
