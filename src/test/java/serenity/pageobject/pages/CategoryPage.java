package serenity.pageobject.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by NoemiRM on 23/01/23
 */

public class CategoryPage extends PageObject {

    public ListOfWebElementFacades get_all_products(){
        return findAll("//div[contains(@class,'product-name')]/a");

    }

    public void go_product_detail(String nameProduct){
        for (WebElement element: get_all_products()) {
            if((element.getText().toUpperCase()).equals(nameProduct.toUpperCase())){
                element.click();
                break;
            }
            
        }

    }

}
