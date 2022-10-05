package org.mateo.automatizacione2eselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    public WebElement addToCarButton;


}
