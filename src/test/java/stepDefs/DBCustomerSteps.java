package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;

public class DBCustomerSteps {

    List<Object> allSSNs = new ArrayList<>();
    List< String> listOfCurrentSSNs = new ArrayList<>();
    @Given("user creates a connection with db using {string} , {string} and {string}")
    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);
    }
    @Given("user provides the query as {string} and {string}")
    public void user_provides_the_query_as_and(String query, String columnName) {

        allSSNs = DatabaseUtility.getColumnData(query,columnName);

        System.out.println(allSSNs);


    }
    @Given("user validates all db data")
    public void user_validates_all_db_data() {

    }



}
