package utilities;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Country;
import pojos.CountryU;
import pojos.Customer;

import java.util.List;

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

    public static Response createCountry(RequestSpecification spec, Country country){

        return given().spec(spec).
                headers("Authorization", "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).
                contentType(ContentType.JSON).
                body(country).
                post("/{first}/{second}");

    }

    public static Response updateCountry(RequestSpecification spec, CountryU country){

        return given().spec(spec).
                headers("Authorization", "Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                contentType(ContentType.JSON).
                body(country).
                put("/{first}/{second}");

    }

    public static Response readUsers(RequestSpecification spec){

        Response response = given().headers("Authorization", "Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).spec(spec).
                contentType(ContentType.JSON).
                get("/{first}/{second}");

        return response;
    }

    public static Response deleteRequest(RequestSpecification spec){

        return given().headers("Authorization", "Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).spec(spec).
                contentType(ContentType.JSON).
                delete("/{first}/{second}/{third}");


    }

    public static Response getRequest(RequestSpecification spec){

        return given().headers("Authorization", "Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).spec(spec).
                contentType(ContentType.JSON).
                get("/{first}/{second}/{third}");


    }




}
