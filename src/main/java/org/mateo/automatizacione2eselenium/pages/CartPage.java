package org.mateo.automatizacione2eselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    public WebElement placeOrderButton;
}
