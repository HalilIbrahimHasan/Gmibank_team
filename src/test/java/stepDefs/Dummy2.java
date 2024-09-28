package stepDefs;

import baseUrls.GMIBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Account;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class Dummy2 extends GMIBaseUrl {
    public static void main(String[] args) {
        //set url
        spec = new RequestSpecBuilder().setBaseUri("https://gmibank.com/").build();
        spec.pathParams("first","api", "second", "tp-accounts" );

        Account acc = new Account();
        acc.setBalance("50000");
        acc.setAccountStatus("ACTIVE");
        acc.setDescription("neauvau account tal");
        acc.setAccountType("CHECKING");
        Response response = given().spec(spec).headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .body(acc).when()
                .post("/{first}/{second}");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
