package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by NoemiRM on 22/01/23
 */
@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

    @FindBy(css = "div.icon-wrapper>div:nth-of-type(2)>a")
    private WebElementFacade linkLogin;

    @FindBy(css = "div.main-menu>ul>li:nth-of-type(3)>a")
    private WebElementFacade linkWomenCategory;

    @FindBy(css = "a.mini-cart-icon")
    private WebElementFacade linkShoppingCart;

    public void click_login(){
        linkLogin.waitUntilEnabled();
        linkLogin.click();
    }

    public void go_women_category_page(){
        linkWomenCategory.waitUntilEnabled();
        linkWomenCategory.click();

    }

    public void go_shopping_cart(){
        linkShoppingCart.waitUntilEnabled();
        linkShoppingCart.click();
    }



}
