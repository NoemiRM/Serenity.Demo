package serenity.pageobject.steps.functional;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import serenity.pageobject.pages.CreateAccountPage;
import serenity.pageobject.pages.HomePage;
import serenity.pageobject.pages.LoginPage;

import static java.lang.Math.random;
import static org.junit.Assert.assertEquals;

/**
 * Created by NoemiRM on 24/01/23
 */
public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;
    CreateAccountPage createAccountPage;

    @And("User is at Home Page")
    public void andOpenHome(){
        homePage.open();
    }

    @Given("User {string} is registered")
    public void userIsRegistered(String arg0) {
        andOpenHome();
        userRegistersOnTheWeb(arg0);
    }

    @When("User requests to login with right access")
    public void userRequestsToLoginWithRightAccess() {

    }

    @Then("Application shows user page")
    public void applicationShowsUserPage() {
    }

    @And("User {string} registers on the web")
    public void userRegistersOnTheWeb(String arg0) {
        double auxNum = random() * 100000;
        Serenity.setSessionVariable("email").to("juan.perez"+auxNum+"@yopmail.com");

        homePage.click_login();
        loginPage.click_create_account();
        createAccountPage.enter_full_name(arg0);
        createAccountPage.enter_email(Serenity.sessionVariableCalled("email"));
        createAccountPage.enter_password("123456");
        createAccountPage.sign_up_information();

    }

    @When("User navigates to women's category page")
    public void userNavigatesToWomenSCategoryPage() {
        homePage.go_women_category_page();
    }



}
