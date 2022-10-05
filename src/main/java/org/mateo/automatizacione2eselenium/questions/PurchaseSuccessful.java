package org.mateo.automatizacione2eselenium.questions;

import org.mateo.automatizacione2eselenium.pages.SuccessfulMessage;
import org.mateo.automatizacione2eselenium.screenplay.Question;
import org.mateo.automatizacione2eselenium.utils.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PurchaseSuccessful implements Question {

    private SuccessfulMessage successfulMessage;

    @Override
    public Boolean answeredBy(WebDriver driver) {
        initPages(driver);
        Sleep.sleep();
        return successfulMessage.successfulMessage.isDisplayed();
    }

    private void initPages(WebDriver driver) {
        successfulMessage = PageFactory.initElements(driver, SuccessfulMessage.class);
    }

    public static PurchaseSuccessful thePurchaseIsSuccessful(){
        return new PurchaseSuccessful();
    }


}


