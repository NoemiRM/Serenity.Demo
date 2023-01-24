package serenity.pageobject.apis;

import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NoemiRM on 24/01/23
 */
public class InfoCountryService {

    public static void getDetailsCountryByAlphaCode(String accessKey, String alphaCode){
        String url = "http://api.countrylayer.com/v2/alpha/"+alphaCode;
        Map<String, String> params = new HashMap<>();
        params.put("access_key", accessKey);

        SerenityRest.given().params(params)
                .when().get(url);

    }

}
