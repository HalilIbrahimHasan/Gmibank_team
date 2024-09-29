package stepDefs;

import baseUrls.GMIBaseUrl;
import io.restassured.response.Response;
import pojos.CountryU;
import utilities.APIUtils;

import static stepDefs.BaseSteps.response;
import static utilities.APIUtils.readUsers;

public class CountryDummy extends GMIBaseUrl {

    public static void main(String[] args) {
        setup();
        spec.pathParams("first", "api", "second" , "tp-countries");

        Response response = readUsers(spec);

//        response.prettyPrint();

        CountryU [] listOfCountries = response.as(CountryU[].class);



        for (CountryU eachCountry : listOfCountries){
            System.out.println(eachCountry);
        }

    }


}
