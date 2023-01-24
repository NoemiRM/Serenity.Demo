package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

/**
 * Created by NoemiRM on 23/01/23
 */

public class DetailProductPage extends PageObject {
    @FindBy(css = "input[name='qty']")
    private WebElementFacade inputQuantity;

    @FindBy(css = "button.primary")
    private WebElementFacade btnAddCart;

    public void enter_quantity(String quantity){
        inputQuantity.waitUntilEnabled();
        inputQuantity.click();
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    public void send_cart_shopping(){
        btnAddCart.click();
    }

    public ListOfWebElementFacades get_product_options(){
        return findAll("//ul[contains(@class,'variant-option-list')]//a");

    }


    public void select_option(String option){
        for (WebElementFacade element: get_product_options()) {
            if((element.getText().toUpperCase()).equals(option.toUpperCase())){
                element.click();
                break;
            }
        }

    }


}
