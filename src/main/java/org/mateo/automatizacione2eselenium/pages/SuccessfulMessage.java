package org.mateo.automatizacione2eselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulMessage {

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    public WebElement successfulMessage;
}
