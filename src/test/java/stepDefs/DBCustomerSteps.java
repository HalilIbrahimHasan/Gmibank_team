package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;

public class DBCustomerSteps {

    List<Object> data = new ArrayList<>();
    List< String> listOfCurrentSSNs = new ArrayList<>();
    @Given("user creates a connection with db using {string} , {string} and {string}")
    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);
    }
    @Given("user provides the query as {string} and {string}")
    public void user_provides_the_query_as_and(String query, String columnName) {

        data = DatabaseUtility.getColumnData(query,columnName);

        System.out.println(data);


    }
    @Given("user validates all db data")
    public void user_validates_all_db_data() {

    }
    @Then("user prints them on the pdf and close connection")
    public void user_prints_them_on_the_pdf_and_close_connection() {

    }


}
