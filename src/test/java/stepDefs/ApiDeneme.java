package stepDefs;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Customer;
import pojos.Registrant;
import utilities.APIUtils;

import static io.restassured.RestAssured.given;

public class ApiDeneme {

    public static void main(String[] args) {
        //base url  gmibank.com/
        //path params /api/register
        //endpoint baseurl + pathParams
        //GET , POST : endpoint, body, JSON header

        String  token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjd29idXJuIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE3MjcxMTY2NTN9.dOQdFkxFP_nKh72dmvXWb3nyJXXN00zfBRuLx049tFaf64nDLQN0ujdP0X_YcMpvRW4QoAiw7zLfvvbaQV8oMw";

        //1)Set base url
        RequestSpecification spec = new RequestSpecBuilder().
                setBaseUri("https://gmibank.com").
                build();

        //2) set path params
        spec.pathParams("first", "api", "second", "register");

        //3) data varsa, body kullan
        Faker faker = new Faker();
        Customer customer = new Customer();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setSsn(faker.idNumber().ssnValid());
        customer.setEmail(faker.internet().emailAddress());
        customer.setMobilePhoneNumber(faker.phoneNumber().phoneNumber());
        customer.setLogin(customer.getFirstName()+customer.getLastName());
        customer.setPassword(faker.internet().password(12, 22, true, true));

        //4) send a post request

        Response response = given().spec(spec).
                contentType(ContentType.JSON).
                body(customer).
                post("/{first}/{second}");

        response.prettyPrint();







    }
}
