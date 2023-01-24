package serenity.pageobject.apis;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NoemiRM on 24/01/23
 */
public class InfoCountryService {

    public static Response getDetailsCountryByAlphaCode(String accessKey, String alphaCode){
        String url = "http://api.countrylayer.com/v2/alpha/"+alphaCode;

        Response response = SerenityRest.given().contentType("application/json")
                .and().param("access_key",accessKey)
                .when().get(url);

        return response;
    }

    public static void postCreateCountry(String name, String alpha2, String alpha3){
        Map<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("alpha2_code",alpha2);
        body.put("alpha3_code",alpha3);

        SerenityRest.given().header("Content-Type","application/json")
                .and().body(body)
                .when().post("http://api.countrylayer.com/v2");

    }

}
