package serenity.pageobject.steps.functional;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.Ensure;
import serenity.pageobject.pages.CreateAccountPage;
import serenity.pageobject.pages.HomePage;
import serenity.pageobject.pages.LoginPage;
import serenity.pageobject.pages.ShoppingCartPage;

import java.util.Map;

import static io.netty.util.internal.SystemPropertyUtil.contains;
import static java.lang.Math.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by NoemiRM on 24/01/23
 */
public class ShoppingCartSteps {
    ShoppingCartPage shoppingCartPage;

    @And("User enters information to shipping address")
    public void userEntersInformationToShippingAddress(DataTable dataTable) {
        userGoesToViewCartPageThroughPopup();
        userGoesToCheckoutPage();
        Map<String, String> detailShipping = dataTable.asMap(String.class, String.class);
        shoppingCartPage.enter_full_name(detailShipping.get("fullName"));
        shoppingCartPage.enter_telephone(detailShipping.get("telephone"));
        shoppingCartPage.enter_address(detailShipping.get("address"));
        shoppingCartPage.select_country(detailShipping.get("country"));
        shoppingCartPage.select_province(detailShipping.get("province"));
        shoppingCartPage.enter_postcode(detailShipping.get("postcode"));
        shoppingCartPage.select_shipping_method();
        userContinuesCheckoutPage();
        shoppingCartPage.select_cash_payment();
        userContinuesCheckoutPage();


    }


    @And("User goes to view cart page through popup")
    public void userGoesToViewCartPageThroughPopup() {
        shoppingCartPage.go_view_cart_popup();
    }


    @And("User continues checkout page")
    public void userContinuesCheckoutPage() {
        shoppingCartPage.go_continue_checkout_shopping();
    }


    @And("User goes to checkout page")
    public void userGoesToCheckoutPage() {
        shoppingCartPage.go_checkout_products_page();
    }

    @Then("everShop page shows information about user's order")
    public void evershopPageShowsInformationAboutUserSOrder(DataTable dataTable) {
        Map<String, String> dataShopping = dataTable.asMap(String.class, String.class);
        String[] ArrayProducts = dataShopping.get("products").split(",");

        shoppingCartPage.get_shipping_address();
        assertThat(shoppingCartPage.get_shipping_address(), equalTo(dataShopping.get("address")));
        assertThat(shoppingCartPage.get_shipping_province_country(), equalTo(dataShopping.get("country")));
        assertThat(shoppingCartPage.get_shipping_postcode(), equalTo(dataShopping.get("postcode")));

        for (String nameProduct : ArrayProducts) {
            assertThat(shoppingCartPage.is_name_product_presented(nameProduct),equalTo(true));

        }

    }
}
