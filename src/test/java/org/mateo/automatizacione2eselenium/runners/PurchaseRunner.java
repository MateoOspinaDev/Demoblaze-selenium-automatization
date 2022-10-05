package org.mateo.automatizacione2eselenium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/purchase.feature"},
        glue = {"org.mateo.automatizacione2eselenium.stepdefinitions"},
        plugin = { "pretty",  "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class PurchaseRunner {

}
