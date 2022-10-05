package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.model.Product;
import org.mateo.automatizacione2eselenium.pages.HomePage;
import org.mateo.automatizacione2eselenium.pages.ProductPage;
import org.mateo.automatizacione2eselenium.screenplay.Action;
import org.mateo.automatizacione2eselenium.utils.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
        Sleep.sleep();
        homePage.home.click();
        Sleep.sleep();
        homePage.categoryMenu(product.getCategory()).click();
        Sleep.sleep();
        homePage.product(product.getName()).click();
        Sleep.sleep();
        productPage.addToCarButton.click();
        Sleep.sleep();
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
