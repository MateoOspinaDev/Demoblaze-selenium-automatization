package org.mateo.automatizacione2eselenium.screenplay;

import org.openqa.selenium.WebDriver;

public interface Question {
    Boolean answeredBy(WebDriver driver);
}
