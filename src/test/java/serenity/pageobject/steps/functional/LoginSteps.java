package serenity.pageobject.steps.functional;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import serenity.pageobject.pages.HomePage;
import serenity.pageobject.pages.LoginPage;

import static org.junit.Assert.assertEquals;

/**
 * Created by NoemiRM on 26/01/23
 */
public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;

    @And("User is at Home Page")
    public void andOpenHome(){
        homePage.open();
    }

    @Given("User {string} is registered")
    public void userIsRegistered(String arg0) {

    }

    @When("User requests to login with right access")
    public void userRequestsToLoginWithRightAccess() {
        homePage.click_login();
        loginPage.enter_email("email");
        loginPage.enter_password("password");
        loginPage.click_submit();
    }

    @Then("Application shows user page")
    public void applicationShowsUserPage() {
    }
}
