package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by NoemiRM on 22/01/23
 */

public class CreateAccountPage extends PageObject {
    @FindBy(css = "input[name='full_name']")
    private WebElementFacade inputFullName;

    @FindBy(css = "input[name='email']")
    private WebElementFacade inputEmail;

    @FindBy(css = "input[name='password']")
    private WebElementFacade inputPassword;

    @FindBy(css = "div.form-submit-button>button")
    private WebElementFacade btnSignUp;

    public void enter_full_name(String fullName){
        inputFullName.click();
        inputFullName.clear();
        inputFullName.sendKeys(fullName);

    }

    public void enter_email(String email){
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);

    }

    public void enter_password(String password){
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);

    }

    public void sign_up_information(){
        btnSignUp.click();
    }

}
