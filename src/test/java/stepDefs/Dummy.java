package stepDefs;

import baseUrls.GMIBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class Dummy extends GMIBaseUrl {

    public static void main(String[] args) {
        //set url
        spec = new RequestSpecBuilder().setBaseUri("https://gmibank.com/").build();
        spec.pathParams("first","api", "second", "users" );

        Response response = given().spec(spec).headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get("/{first}/{second}");
        response.prettyPrint();
    }

    public void runApi(){
        spec.pathParams("first","api", "second", "tp-accounts" );

        Response response = given().spec(spec).headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get("/{first}/{second}");
        response.prettyPrint();


    }



}
