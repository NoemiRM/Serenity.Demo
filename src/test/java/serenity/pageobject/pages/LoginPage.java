package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by NoemiRM on 22/01/23
 */

public class LoginPage extends PageObject {

    @FindBy(css = "input[name='email']")
    private WebElementFacade inputEmail;

    @FindBy(css = "input[name=password]")
    private WebElementFacade inputPassword;

    @FindBy(css = "div.form-submit-button>button")
    private WebElementFacade btnSignIn;

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

    public void click_submit(){
        btnSignIn.click();
    }

}
