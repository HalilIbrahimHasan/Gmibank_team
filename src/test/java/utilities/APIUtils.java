package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Customer;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class APIUtils {

    public static Response getUsers(RequestSpecification spec){

         Response response = given().spec(spec).
                 headers("Authorization", "Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                get("/{first}/{second}");

        return response;
    }

    public static Response createUser(RequestSpecification spec, Customer customer){

        Response response = given().spec(spec).
                contentType(ContentType.JSON).
                body(customer).
                post("/{first}/{second}");

        return response;
    }

    public static Response readUsers(RequestSpecification spec){

        Response response = given().headers("Authorization", "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).spec(spec).
                contentType(ContentType.JSON).
                get("/{first}/{second}");

        return response;
    }


}
