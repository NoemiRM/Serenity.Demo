package serenity.pageobject.apis;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

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

}
