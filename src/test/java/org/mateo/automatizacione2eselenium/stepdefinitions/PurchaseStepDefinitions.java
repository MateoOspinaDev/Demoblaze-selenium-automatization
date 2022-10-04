package org.mateo.automatizacione2eselenium.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseStepDefinitions {

    private WebDriver driver;
    WebDriverWait wt;

    @Before
    public void setTheStage(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(); // Inicializa el navegador
        wt = new WebDriverWait(driver,10);
        driver.manage().window().maximize(); // Maximiza la ventana
        driver.get("https://www.demoblaze.com/index.html"); // Abre la página

    }

    @Given("^(.*) is authenticated$")
    public void Authenticate(String actorName) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.id("login2"));
        WebElement username = driver.findElement(By.id("loginusername"));
        WebElement password = driver.findElement(By.id("loginpassword"));
        WebElement LOG_IN_BUTTON = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));

        login.click();

        wt.until(ExpectedConditions.visibilityOf(LOG_IN_BUTTON));
        username.sendKeys("admin");
        password.sendKeys("admin");
        LOG_IN_BUTTON.click();
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) throws InterruptedException {
        Thread.sleep(1000);
        WebElement HOME = driver.findElement(By.xpath("//a[text()='Home ']"));
        HOME.click();
        Thread.sleep(1000);
        WebElement CATEGORY_MENU = driver.findElement(By.xpath("//a[@id='itemc'][text()='"+category+"']"));
        CATEGORY_MENU.click();
        Thread.sleep(1000);
        WebElement PRODUCT = driver.findElement(By.xpath("//div[contains(@class,'card')]//a[text()='"+product+"']"));
        PRODUCT.click();
        Thread.sleep(1000);
        WebElement ADD_TO_CART = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        ADD_TO_CART.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }


    @When("^[a-zA-Z]{3,50} makes the purchase$")
    public void purchase() throws InterruptedException {
        WebElement CART = driver.findElement(By.xpath("//a[text()='Cart']"));
        CART.click();
        Thread.sleep(1000);
        WebElement PLACE_ORDER = driver.findElement(By.xpath("//button[text()='Place Order']"));
        PLACE_ORDER.click();
        WebElement NAME = driver.findElement(By.id("name"));
        WebElement COUNTRY = driver.findElement(By.id("country"));
        WebElement CITY = driver.findElement(By.id("city"));
        WebElement CREDIT_CARD = driver.findElement(By.id("card"));
        WebElement MONTH = driver.findElement(By.id("month"));
        WebElement YEAR = driver.findElement(By.id("year"));
        WebElement PURCHASE = driver.findElement(By.xpath("//button[text()='Purchase']"));
        NAME.sendKeys("Mateo");
        COUNTRY.sendKeys("Colombia");
        CITY.sendKeys("Bogota");
        CREDIT_CARD.sendKeys("123456789");
        MONTH.sendKeys("12");
        YEAR.sendKeys("2021");
        PURCHASE.click();
    }


    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() throws InterruptedException {
        Thread.sleep(1000);
        WebElement THANK_YOU = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));
        Assert.assertTrue(THANK_YOU.isDisplayed());
        driver.quit();
    }

}
