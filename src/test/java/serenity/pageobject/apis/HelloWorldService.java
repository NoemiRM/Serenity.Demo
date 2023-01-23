package serenity.pageobject.apis;

import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NoemiRM on 4/01/23
 */
public class HelloWorldService {
    public static void createBookingApi(String firstname, String lastname, Integer totalPrice, Boolean depositPaid,
                                        String checkIn, String checkout, String additionalNeeds){

        Map<String, Object> body = new HashMap<>();
        body.put("firstname", firstname);
        body.put("lastname",lastname);
        body.put("totalprice",totalPrice);
        body.put("depositpaid",depositPaid);
        body.put("checkin",checkIn);
        body.put("checkin",checkout);
        body.put("additionalneeds",additionalNeeds);

        SerenityRest.given().header("Ocp-Apim-Subscription-Key","2cc3706d41a04dae833877a386cea963")
                .header("Content-Type","application/json")
                .and().body(body)
                .when().post("https://restful-booker.herokuapp.com/booking");
    }

}
