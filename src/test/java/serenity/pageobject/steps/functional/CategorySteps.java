package serenity.pageobject.steps.functional;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import serenity.pageobject.pages.*;

import java.util.Map;

import static java.lang.Math.random;
import static org.junit.Assert.assertEquals;

/**
 * Created by NoemiRM on 24/01/23
 */
public class CategorySteps {
    CategoryPage categoryPage;
    DetailProductPage detailProductPage;

    @And("User goes to details of {string} product")
    public void userGoesToDetailsOfProduct(String arg0) {
        categoryPage.go_product_detail(arg0);

    }


    @And("User adds {string} product to shopping cart")
    public void userAddsProductToShoppingCart(String arg0, DataTable dataTable) {
        userGoesToDetailsOfProduct(arg0);
        Map<String,String> detailsProduct = dataTable.asMap(String.class, String.class);

        detailProductPage.select_option(detailsProduct.get("size"));
        detailProductPage.select_option(detailsProduct.get("color"));
        detailProductPage.enter_quantity(detailsProduct.get("quantity"));
        detailProductPage.send_cart_shopping();
    }

}
