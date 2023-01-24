package serenity.pageobject.steps.integration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import serenity.pageobject.apis.InfoCountryService;
import serenity.pageobject.helper.DatabaseHelper;
import serenity.pageobject.model.yml.UserYml;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;


/**
 * Created by NoemiRM on 24/01/23.
 */
public class InfoCountrySteps {
    InfoCountryService infoCountryService;

    @When("User has right access to use the service")
    public void userHasRightAccessToUseTheService() {
        Serenity.setSessionVariable("access_key").to("a45dfdef1eb6ebea0d0034f4cb78dad5");

    }

    @Then("User requests information {string} alpha code")
    public void userRequestsInformationAlphaCode(String arg0) {
        InfoCountryService.getDetailsCountryByAlphaCode(
                Serenity.sessionVariableCalled("access_key"),
                arg0.toUpperCase());

    }

    @Given("Service returns with country's information")
    public void serviceReturnsWithCountrySInformation(DataTable dataTable) {
        Map<String,String> infoCountry = dataTable.asMap(String.class, String.class);
        SerenityRest.then().log().all();


    }

    @And("Service returns OK status {int}")
    public void serviceReturnsOKStatus(int arg0) {
        SerenityRest.then().log().all().statusCode(arg0);
    }
}
