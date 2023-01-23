package serenity.pageobject.steps.integration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import serenity.pageobject.apis.HelloWorldService;
import serenity.pageobject.helper.DatabaseHelper;
import serenity.pageobject.model.yml.UserYml;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;


/**
 * Created by NoemiRM on 10/01/23.
 */
public class HelloWorldSteps {

    @Given("First Step")
    public void givenFirstStep(String nameClient) {
        String nameFileUser = "user_"+nameClient.replace(' ', '_')+".yml";
        DatabaseHelper.get_user_data(nameFileUser.toLowerCase());
        UserYml userYml = Serenity.sessionVariableCalled("user_data");


    }

    @When("Second Step")
    public void whenSecondStep() {
        UserYml userYml = Serenity.sessionVariableCalled("user_data");

        HelloWorldService.createBookingApi(
                "Jim",
                "Brown",
                111,
                true,
                "2018-01-01",
                "2019-01-01",
                "Breakfast");

    }

    @Then("Third Step")
    public void thenThirdStep() {
        SerenityRest.then().log().all().statusCode(200);
    }

}
