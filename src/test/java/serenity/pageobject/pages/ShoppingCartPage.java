package serenity.pageobject.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Select;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by NoemiRM on 23/01/23
 */

public class ShoppingCartPage extends PageObject {
    @FindBy(css = "div.shopping-cart-checkout-btn>a")
    private WebElementFacade linkCheckout;

    @FindBy(css = "input[name='address[full_name]']")
    private WebElementFacade inputFullName;

    @FindBy(name = "address[telephone]")
    private WebElementFacade inputTelephone;

    @FindBy(css = "input[placeholder='Address']")
    private WebElementFacade inputAddress;

    @FindBy(css = "input[placeholder='City']")
    private WebElementFacade inputCity;

    @FindBy(id = "address[country]")
    private WebElementFacade selectCountry;

    @FindBy(id = "address[province]")
    private WebElementFacade selectProvince;

    @FindBy(name = "address[postcode]")
    private WebElementFacade inputPostCode;

    @FindBy(css = "span.pl-1")
    private WebElementFacade spanFreeShipping;

    @FindBy(css = "button.primary")
    private WebElementFacade btnContinue;

    @FindBy(xpath = "//div[contains(@class,'payment-method-list')][1]//a")
    private WebElementFacade optionCash;

    @FindBy(css = "div.full-name")
    private WebElementFacade divFullName;

    @FindBy(css = "div.address-one")
    private WebElementFacade divAddress;

    @FindBy(css = "div.city-province-postcode>div:nth-of-type(1)")
    private WebElementFacade divPostcode;

    @FindBy(css = "div.city-province-postcode>div:nth-of-type(2)")
    private WebElementFacade divProvinceCountry;

    @FindBy(css = "div.telephone")
    private WebElementFacade divTelephone;

    @FindBy(css = "a.add-cart-popup-button")
    private WebElementFacade linkGoCartPopup;


    public void go_checkout_products_page() {
        linkCheckout.waitUntilEnabled();
        linkCheckout.click();

    }

    public void go_view_cart_popup(){
        linkGoCartPopup.waitUntilEnabled();
        linkGoCartPopup.click();
    }

    public void enter_full_name(String fullName) {
        inputFullName.waitUntilEnabled();
        inputFullName.click();
        inputFullName.clear();
        inputFullName.sendKeys(fullName);

    }

    public void enter_telephone(String phone) {
        inputTelephone.waitUntilEnabled();
        inputTelephone.click();
        inputTelephone.clear();
        inputTelephone.sendKeys(phone);

    }

    public void enter_address(String address) {
        inputAddress.waitUntilEnabled();
        inputAddress.click();
        inputAddress.clear();
        inputAddress.sendKeys(address);

    }

    public void enter_city(String city) {
        inputCity.waitUntilEnabled();
        inputCity.click();
        inputCity.clear();
        inputCity.sendKeys(city);

    }

    public void select_country(String country) {
        selectCountry.waitUntilEnabled();
        selectCountry.selectByVisibleText(country);

    }

    public void select_province(String province) {
        selectProvince.waitUntilClickable();
        selectProvince.selectByVisibleText(province);

    }

    public void enter_postcode(String postcode) {
        inputPostCode.waitUntilEnabled();
        inputPostCode.click();
        inputPostCode.sendKeys(postcode);

    }

    public void select_shipping_method() {
        spanFreeShipping.waitUntilEnabled();
        spanFreeShipping.click();

    }

    public void go_continue_checkout_shopping() {
        btnContinue.waitUntilEnabled();
        btnContinue.click();

    }

    public void select_cash_payment() {
        optionCash.waitUntilEnabled();
        withTimeoutOf(Duration.ofSeconds(10))
                .find(By.xpath("//div[contains(@class,'payment-method-list')][1]//a"))
                .click();

    }

    public String get_shipping_fullName() {
        divFullName.waitUntilEnabled();
        return divFullName.getText();

    }

    public String get_shipping_address() {
        divAddress.waitUntilEnabled();
        return divAddress.getText();

    }

    public String get_shipping_postcode() {
        divPostcode.waitUntilEnabled();
        return divPostcode.getText();

    }

    public String get_shipping_province_country(){
        divProvinceCountry.waitUntilEnabled();
        return divProvinceCountry.getText();
    }

    public String get_shipping_telephone(){
        divTelephone.waitUntilEnabled();
        return divTelephone.getText();

    }

    public ListOfWebElementFacades get_all_names_products(){
        return findAll("//div[@class='product-column']/div/span");

    }

    public boolean is_name_product_presented(String nameProduct){
        boolean value = false;
        for (WebElement element: get_all_names_products()) {
            if(element.getText().equals(nameProduct)){
                value = true;
                break;
            }
        }
        return value;

    }

}
