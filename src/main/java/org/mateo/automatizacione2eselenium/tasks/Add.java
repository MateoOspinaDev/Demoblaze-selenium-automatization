package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.model.Product;
import org.mateo.automatizacione2eselenium.pages.HomePage;
import org.mateo.automatizacione2eselenium.pages.ProductPage;
import org.mateo.automatizacione2eselenium.screenplay.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.mateo.automatizacione2eselenium.utils.Wait.waitingBad;

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
        waitingBad();
        homePage.home.click();
        waitingBad();
        homePage.categoryMenu(product.getCategory()).click();
        waitingBad();
        homePage.product(product.getName()).click();
        waitingBad();
        productPage.addToCarButton.click();
        waitingBad();
        driver.switchTo().alert().accept();
    }

    private void initPages(WebDriver driver) {
        productPage = PageFactory.initElements(driver, ProductPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public static Action toCar(Product product) {
        return new Add(product);
    }
}
