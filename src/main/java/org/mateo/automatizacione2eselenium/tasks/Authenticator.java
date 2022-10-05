package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.model.User;
import org.mateo.automatizacione2eselenium.pages.HomePage;
import org.mateo.automatizacione2eselenium.pages.LoginPage;
import org.mateo.automatizacione2eselenium.pornombrar.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Authenticator implements Action {

    private final User user;
    private LoginPage loginPage;
    private HomePage homePage;

    public Authenticator(User user) {
        this.user = user;
    }

    @Override
    public void perform(WebDriver driver) {
        initPages(driver);
        homePage.loginBanner.click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
        loginPage.username.sendKeys(user.getUsername());
        loginPage.password.sendKeys(user.getPasswork());
        loginPage.loginButton.click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
    }

    private void initPages(WebDriver driver) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public static Action authenticate(User user) {
        return new Authenticator(user);
    }
}
