package stepDefs;

import io.cucumber.java.en.*;
import pages.UserManagementPage;
import utilities.WDController;

public class UserManagementSteps {

    UserManagementPage ump = new UserManagementPage();

    @Given("user clicks and navigates to {string}")
    public void user_clicks_and_navigates_to(String text) {
        WDController.waitAndClick(text);
    }

}
