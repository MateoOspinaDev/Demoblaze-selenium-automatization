package org.mateo.automatizacione2eselenium.questions;

import org.openqa.selenium.WebDriver;

public interface Question {
    Boolean answeredBy(WebDriver driver);
}
