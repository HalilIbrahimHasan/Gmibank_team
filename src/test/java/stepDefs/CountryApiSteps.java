package stepDefs;

import baseUrls.GMIBaseUrl;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.CountryU;
import utilities.TxtWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static stepDefs.BaseSteps.*;
import static utilities.APIUtils.*;
import static utilities.ApiValidations.*;

public class CountryApiSteps extends GMIBaseUrl {

    @Given("user sets the base url for all apis")
    public void user_sets_the_base_url_for_all_apis() {

        setup();
    }
    @Given("user sets path params")
    public void user_sets_path_params(DataTable dataTable) {

        setPathParams(dataTable,spec);

    }

    @Given("user sets the data {string} and {string}")
    public void user_sets_the_data_and(String idJson, String value) {

        //{"name" : "GroupGen"} // {"name": "string"}
        country.setName(value);

    }

    @When("user sends POST request")
    public void user_sends_post_request() {

        response = createCountry(spec, country);
    }

    @Then("user validates country")
    public void user_validates_country() throws IOException {

        response.then().assertThat().statusCode(201);

        //validation 1

                response.then().contentType(ContentType.JSON).
                        body("name",equalTo( country.getName()));

        //validation 2
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getString("name"), country.getName());

          //validation 3
        CountryU countryU1 = response.as(CountryU.class);
        Assert.assertEquals(countryU1.getName(), country.getName());
        Assert.assertTrue(countryU1.getId() != 0);

        //validation 4
        Map<String, Object> data = response.as(HashMap.class);
        Assert.assertEquals(data.get("name"), country.getName());




        //validation 5
        Gson gson = new Gson();//json to java deserialization
                               //java to json serialization
        //String name = Group
        //int id  = 123              {"name" : "Group", "id" : 123}
        CountryU countryU2 = gson.fromJson(response.asString(), CountryU.class);
        Assert.assertEquals(countryU2.getName(), country.getName());

        //validation 6
        ObjectMapper obj = new ObjectMapper();
        CountryU countryU3 = obj.readValue(response.asString(), CountryU.class);

        Assert.assertEquals(countryU3.getName(),country.getName());

        TxtWriter.txtCountryWriter("CountryData.txt",countryU3);




    }

    @Given("user sets the data for {string} and {string}")
    public void user_sets_the_data_for_and(String id, String name) {
        countryU.setName(name);
        countryU.setId(Integer.parseInt(id));
        System.out.println(countryU);
    }
    @When("user sends PUT request")
    public void user_sends_put_request() {

        response = updateCountry(spec,countryU);

    }

    @When("user validates updated country")
    public void user_validates_updated_country() throws IOException {
        response.then().assertThat().statusCode(200);



        response.then().contentType(ContentType.JSON).
                body("name",equalTo( countryU.getName())).
                body("id",equalTo( countryU.getId()));

        //validation 2
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getString("name"), countryU.getName());

        //validation 3
        CountryU countryU1 = response.as(CountryU.class);
        Assert.assertEquals(countryU1.getName(), countryU.getName());
        Assert.assertEquals(countryU1.getId(), countryU.getId());


        //validation 4
        Map<String, Object> data = response.as(HashMap.class);
        Assert.assertEquals(data.get("name"), countryU.getName());
        Assert.assertEquals(data.get("id"), countryU.getId());


        //validation 5
        Gson gson = new Gson();

        CountryU countryU2 = gson.fromJson(response.asString(), CountryU.class);
        Assert.assertEquals(countryU2.getName(), countryU.getName());
        Assert.assertEquals(countryU2.getId(), countryU.getId());

        //validation 6

        ObjectMapper obj = new ObjectMapper();
        CountryU countryU3 = obj.readValue(response.asString(), CountryU.class);

        Assert.assertEquals(countryU3.getName(),countryU.getName());
        Assert.assertEquals(countryU3.getId(),countryU.getId());

        TxtWriter.txtCountryWriter("CountryData.txt",countryU);


    }


    @Given("user sends request with three params")
    public void user_sends_request_with_three_params(DataTable dataTable) {
        sendRequestWithThreeParams( dataTable, spec);
    }
    @When("user sends Delete request")
    public void user_sends_delete_request() {
        response = deleteRequest(spec);
    }
    @Then("user validates deleted country")
    public void user_validates_deleted_country() {
       response.then().statusCode(204);
    }

    @When("user sends get request")
    public void user_sends_get_request() {
        response = getRequest(spec);
    }

    @When("user validates country data")
    public void user_validates_country_data() {
        response.then().assertThat().statusCode(200);
        CountryU countryU1 = response.as(CountryU.class);
        System.out.println(countryU1);
    }

}
