package org.mateo.automatizacione2eselenium.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mateo.automatizacione2eselenium.model.Product;
import org.mateo.automatizacione2eselenium.model.User;
import org.mateo.automatizacione2eselenium.tasks.Add;

import static org.mateo.automatizacione2eselenium.screenplay.Actors.theActorCalled;
import static org.mateo.automatizacione2eselenium.screenplay.Actors.theActorInTheSpotlight;
import static org.mateo.automatizacione2eselenium.questions.PurchaseSuccessful.thePurchaseIsSuccessful;
import static org.mateo.automatizacione2eselenium.tasks.Authenticator.authenticate;
import static org.mateo.automatizacione2eselenium.tasks.Buy.buy;

public class PurchaseStepDefinitions {

    private static final String USER = ("admin");
    private static final String PASSWORD= ("admin");


    @Given("^(.*) is authenticated$")
    public void Authenticate(String actorName){
        theActorCalled(actorName).wasAbleTo(
                authenticate(User.builder()
                        .username(USER)
                        .passwork(PASSWORD).build())
        );
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) {
        Product aproduct = Product.builder().category(category).name(product).build();
        theActorInTheSpotlight().attemptsTo(
                Add.toCar(aproduct)
        );
    }

    @When("^[a-zA-Z]{3,50} makes the purchase$")
    public void purchase() {
        theActorInTheSpotlight().attemptsTo(
                buy()
        );
    }

    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        theActorInTheSpotlight().shouldSee(
                thePurchaseIsSuccessful()
        );
    }
}
