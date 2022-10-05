package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.pages.CartPage;
import org.mateo.automatizacione2eselenium.pages.HomePage;
import org.mateo.automatizacione2eselenium.pages.PlaceOrderPage;
import org.mateo.automatizacione2eselenium.screenplay.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.mateo.automatizacione2eselenium.utils.Wait.waitingBad;

public class Buy implements Action {

    private CartPage cartPage;
    private PlaceOrderPage placeOrderPage;
    private HomePage homePage;

    public Buy() {
    }

    @Override
    public void perform(WebDriver driver) {
        initPages(driver);
        waitingBad();
        homePage.cart.click();
        waitingBad();
        cartPage.placeOrderButton.click();
        waitingBad();
        placeOrderPage.name.sendKeys("Mateo");
        placeOrderPage.country.sendKeys("Colombia");
        placeOrderPage.city.sendKeys("Bogota");
        placeOrderPage.card.sendKeys("123456789");
        placeOrderPage.month.sendKeys("12");
        placeOrderPage.year.sendKeys("2021");
        placeOrderPage.purchase.click();
    }


    private void initPages(WebDriver driver) {
        placeOrderPage= PageFactory.initElements(driver, PlaceOrderPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public static Action buy() {
        return new Buy();
    }
}

