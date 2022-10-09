package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.model.Product;
import org.mateo.automatizacione2eselenium.pages.HomePage;
import org.mateo.automatizacione2eselenium.pages.ProductPage;
import org.mateo.automatizacione2eselenium.screenplay.actions.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.mateo.automatizacione2eselenium.utils.Wait.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Add implements Action {
    private final Product product;
    private HomePage homePage;
    private ProductPage productPage;


    public Add(Product product) {
        this.product = product;
    }

    @Override
    public void perform(WebDriver driver) {
        initPages(driver);
        waitingForElement(homePage.logoutBanner, driver);
        homePage.home.click();
        homePage.categoryMenu(product.getCategory()).click();

        waitingForDianmicElement(homePage.ByProduct(product.getName()),driver)
                .click();

        waitingForElement(productPage.addToCarButton, driver);
        productPage.addToCarButton.click();
        waitingAndSwitchToAlert(driver)
                .accept();
    }

    private void initPages(WebDriver driver) {
        productPage = PageFactory.initElements(driver, ProductPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public static Action toCar(Product product) {
        return new Add(product);
    }
}
