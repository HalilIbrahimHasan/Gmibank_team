package stepDefs;

import baseUrls.GMIBaseUrl;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.Customer;
import utilities.APIUtils;
import utilities.ApiValidations;
import utilities.ReadTxtFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static stepDefs.BaseSteps.*;
import static utilities.APIUtils.createUser;
import static utilities.APIUtils.getUsers;
import static utilities.ApiValidations.getSSNData;
import static utilities.ApiValidations.ssnMatch;
import static utilities.TxtWriter.txtCustomerWriter;

public class ApiRegistrantSteps extends GMIBaseUrl {


    @Given("user sets the base url and path params")
    public void user_sets_the_base_url_and_path_params() {

        spec.pathParams("first","api", "second", "register");
    }

    @Given("user sets the base url and path params to read")
    public void user_sets_the_base_url_and_path_params_to_read() {
        setup();
        spec.pathParams("first","api", "second", "tp-account-registrations");
    }
    @Given("user sets the api data")
    public void user_sets_the_api_data() {
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setEmail(faker.internet().emailAddress());
        customer.setPassword("Ab"+faker.internet().password(12,20,true,true));
        customer.setLogin(customer.getFirstName()+customer.getLastName());
        customer.setLangKey("en");
        customer.setMobilePhoneNumber(faker.phoneNumber().phoneNumber());
        customer.setSsn(faker.idNumber().ssnValid());
    }
    @When("user sends the request")
    public void user_sends_the_request() {

        response = createUser(spec, customer);

    }
    @Then("user validates user creation")
    public void user_validates_user_creation() throws IOException {

        //validation 1
        response.then().assertThat().statusCode(201);

    }


    @Given("user find the last created user")
    public void user_find_the_last_created_user() {

        Customer customer1 = ReadTxtFile.getLastUser("ApiUsers.txt");

    }
    @Given("user sends a get request")
    public void user_sends_a_get_request() {

        response = getUsers(spec);

    }
    @Then("user validates the created record")
    public void user_validates_the_created_record() throws IOException {

//        response.then().contentType(ContentType.JSON).body("firstName",contains( customer.getFirstName())).
//                body("lastName",contains( customer.getLastName())).
//                body("lastName",contains( customer.getLastName())).
//                body("email",contains( customer.getEmail())).
//                body("login",contains( customer.getLogin())).
//                body("ssn",contains( customer.getSsn())).
//                body("mobilePhoneNumber",contains( customer.getMobilePhoneNumber()));

        //validation 2
//        JsonPath json = response.jsonPath();
//        Assert.assertEquals(json.getString("ssn"), customer.getSsn());
//        Assert.assertEquals(json.getString("login"), customer.getLogin());
//        Assert.assertEquals(json.getString("email"), customer.getEmail());
//        Assert.assertEquals(json.getString("firstName"), customer.getFirstName());
//        Assert.assertEquals(json.getString("lastName"), customer.getLastName());
//
//        //validation 3
//        Customer customer1 = response.as(Customer.class);
//        Assert.assertEquals(customer1.getSsn(), customer.getSsn());
//        Assert.assertEquals(customer1.getLogin(), customer.getLogin());
//        Assert.assertEquals(customer1.getEmail(), customer.getEmail());
//        Assert.assertEquals(customer1.getFirstName(), customer.getFirstName());
//        Assert.assertEquals(customer1.getLastName(), customer.getLastName());

        //validation 4
//        Map<String, Object> data = response.as(HashMap.class);
//        Assert.assertEquals(data.get("ssn"), customer.getSsn());
//        Assert.assertEquals(data.get("login"), customer.getLogin());
//        Assert.assertEquals(data.get("email"), customer.getEmail());
//        Assert.assertEquals(data.get("firstName"), customer.getFirstName());
//        Assert.assertEquals(data.get("lastName"), customer.getLastName());

        //validation 5
//        Gson gson = new Gson();
//
//        Customer customer2 = gson.fromJson(response.asString(), Customer.class);
//
//        Assert.assertEquals(customer2.getSsn(), customer.getSsn());
//        Assert.assertEquals(customer2.getLogin(), customer.getLogin());
//        Assert.assertEquals(customer2.getEmail(), customer.getEmail());
//        Assert.assertEquals(customer2.getFirstName(), customer.getFirstName());
//        Assert.assertEquals(customer2.getLastName(), customer.getLastName());

        //validation 6

//        ObjectMapper obj = new ObjectMapper();
//        Customer customer3 = obj.readValue(response.asString(), Customer.class);
//
//        Assert.assertEquals(customer3.getSsn(), customer.getSsn());
//        Assert.assertEquals(customer3.getLogin(), customer.getLogin());
//        Assert.assertEquals(customer3.getEmail(), customer.getEmail());
//        Assert.assertEquals(customer3.getFirstName(), customer.getFirstName());
//        Assert.assertEquals(customer3.getLastName(), customer.getLastName());


    }
    @Then("user saves the api data")
    public void user_saves_the_api_data() {

        txtCustomerWriter("ApiUsers.txt", customer);

    }
    @Given("user provids path {string} {string}")
    public void user_provids_path(String param1, String param2) {
       spec.pathParams("first", param1, "second", param2);
    }
    @Given("user gets all api user info")
    public void user_gets_all_api_user_info() {
        customers = ReadTxtFile.getAllUsers("ApiUsers.txt");
    }
    @Given("user sends api Get request")
    public void user_sends_api_get_request() {

        response = getUsers(spec);


    }
    @When("user keeps all user api records")
    public void user_keeps_all_user_api_records() {

        System.out.println("customers data : " + customers );
//        response.prettyPrint();

    }
    @Then("user validates all api users")
    public void user_validates_all_api_users() throws IOException {

        //When we have data that do not match properties/ variable names
        //We need to use JsonIgnore properties tag
        ObjectMapper obj = new ObjectMapper();//deserialization

        Customer[] customerArrayData =
                obj.readValue(response.asString(), Customer[].class);

        List<String> actulSSNData = getSSNData(customerArrayData);
        List<String> expectedSSNData = getSSNData(customerArrayData);

        ssnMatch(actulSSNData, expectedSSNData);

    }




}
