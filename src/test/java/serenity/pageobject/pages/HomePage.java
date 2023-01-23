package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by NoemiRM on 22/01/23
 */
@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

    @FindBy(css = "div.icon-wrapper>div:nth-of-type(2)>a")
    private WebElementFacade linkLogin;

    public void click_login(){
        linkLogin.click();
    }


}
