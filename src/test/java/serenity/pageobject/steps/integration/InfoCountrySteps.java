package serenity.pageobject.steps.integration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import serenity.pageobject.apis.InfoCountryService;
import serenity.pageobject.helper.DatabaseHelper;
import serenity.pageobject.model.yml.UserYml;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by NoemiRM on 24/01/23.
 */
public class InfoCountrySteps {

    @When("User has right access to use the service")
    public void userHasRightAccessToUseTheService() {
        Serenity.setSessionVariable("access_key").to("a45dfdef1eb6ebea0d0034f4cb78dad5");

    }

    @Then("User requests information {string} alpha code")
    public void userRequestsInformationAlphaCode(String arg0) {
        Serenity.setSessionVariable("response_api").to(
                InfoCountryService.getDetailsCountryByAlphaCode(
                Serenity.sessionVariableCalled("access_key"),
                arg0.toUpperCase()));

    }

    @Given("Service returns with country's information")
    public void serviceReturnsWithCountrySInformation(DataTable dataTable) {
        Response response = Serenity.sessionVariableCalled("response_api");
        Map<String,String> infoCountry = dataTable.asMap(String.class, String.class);
        SerenityRest.then().log().all();

        assertThat(response.body().path("name"),equalTo(infoCountry.get("name")));
        assertThat(response.body().path("alpha2Code"),equalTo(infoCountry.get("alpha2Code")));
        assertThat(response.body().path("capital"),equalTo(infoCountry.get("capital")));

    }

    @And("Service returns OK status {int}")
    public void serviceReturnsOKStatus(int arg0) {
        SerenityRest.then().log().all().statusCode(arg0);
    }

    @Then("User requests to create a new Country")
    public void userRequestsToCreateANewCountry(DataTable dataTable) {
        Map<String,String> infoCountry = dataTable.asMap(String.class, String.class);

        InfoCountryService.postCreateCountry(
                infoCountry.get("name"),
                infoCountry.get("alpha2Code"),
                infoCountry.get("alpha3Code"));

    }
}
