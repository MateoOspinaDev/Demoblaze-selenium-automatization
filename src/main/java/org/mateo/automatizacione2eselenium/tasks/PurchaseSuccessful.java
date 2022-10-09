package org.mateo.automatizacione2eselenium.tasks;

import org.mateo.automatizacione2eselenium.pages.SuccessfulMessage;
import org.mateo.automatizacione2eselenium.screenplay.questions.Question;
import org.mateo.automatizacione2eselenium.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PurchaseSuccessful implements Question {

    private SuccessfulMessage successfulMessage;

    @Override
    public Boolean answeredBy(WebDriver driver) {
        initPages(driver);
        Wait.waitingForElement(successfulMessage.successfulMessageOfPurchase, driver);
        return successfulMessage.successfulMessageOfPurchase.isDisplayed();
    }

    private void initPages(WebDriver driver) {
        successfulMessage = PageFactory.initElements(driver, SuccessfulMessage.class);
    }

    public static PurchaseSuccessful thePurchaseIsSuccessful(){
        return new PurchaseSuccessful();
    }


}


