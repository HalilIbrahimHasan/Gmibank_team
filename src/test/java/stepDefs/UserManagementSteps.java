package stepDefs;

import io.cucumber.java.en.*;
import pages.UserManagementPage;
import utilities.WDController;

import static stepDefs.BaseSteps.registrant;
import static stepDefs.BaseSteps.ump;

public class UserManagementSteps {



    @Given("user clicks and navigates to {string}")
    public void user_clicks_and_navigates_to(String text) {

        WDController.waitAndClick(text);
    }

    @When("user gets to last page of pagination")
    public void user_gets_to_last_page_of_pagination() {
        WDController.waitAndClick(ump.getLastPage());
    }


    @Then("user navigates to current user actions")
    public void user_navigates_to_current_user_actions() {

        ump.findUserAndEditActions(registrant);
    }

    @Then("user assigns the user {string}")
    public void user_assigns_the_user(String role) {
        ump.selectUserRole(role);
    }

    @Then("user activates the current role")
    public void user_activates_the_current_role() {
        ump.findUserAndActivate(registrant);
    }

    @Then("user refreshes the page")
    public void user_refreshes_the_page() {
        WDController.refreshThePage();
        WDController.sleep(3000);
    }
}
