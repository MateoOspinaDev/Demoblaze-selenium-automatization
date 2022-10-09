package org.mateo.automatizacione2eselenium.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mateo.automatizacione2eselenium.model.Product;
import org.mateo.automatizacione2eselenium.model.User;
import org.mateo.automatizacione2eselenium.tasks.Add;

import static org.mateo.automatizacione2eselenium.screenplay.actor.ActorsLogic.theActorCalled;
import static org.mateo.automatizacione2eselenium.screenplay.actor.ActorsLogic.theActorInTheSpotlight;
import static org.mateo.automatizacione2eselenium.tasks.PurchaseSuccessful.thePurchaseIsSuccessful;
import static org.mateo.automatizacione2eselenium.tasks.Authenticator.authenticate;
import static org.mateo.automatizacione2eselenium.tasks.Buy.buy;

public class PurchaseStepDefinitions {

    private static final String USER = ("admin");
    private static final String PASSWORD= ("admin");


    @Given("^(.*) is authenticated$")
    public void AuthenticateUser(String actorName){
        theActorCalled(actorName)
                .wasAbleTo(authenticate(User.builder()
                        .username(USER)
                        .password(PASSWORD).build())
        );
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCartAProduct(String category, String product) {
        Product aProduct = Product.builder().category(category).name(product).build();
        theActorInTheSpotlight()
                .attemptsTo(
                    Add.toCar(aProduct)
        );
    }

    @When("^[a-zA-Z]{3,50} makes the purchase$")
    public void purchaseTheProducts() {
        theActorInTheSpotlight().attemptsTo(
                buy()
        );
    }

    @Then("should see the message Thank you for your purchase")
    public void theUserShouldSeeTheMessageThankYouForYourPurchase() {
        String message = "Thank you for your purchase";
        theActorInTheSpotlight().shouldSee(
                thePurchaseIsSuccessful()
        );
    }
}
