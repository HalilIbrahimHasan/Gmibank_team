package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.WDController;

import java.time.Duration;

import static stepDefs.BaseSteps.eump;
import static stepDefs.BaseSteps.lp;

public class EmployeeUsermanagementSteps {

    @Then("user validates customer management page")
    public void userValidatesCustomerManagementPage() {

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5), eump.employeeCreateCustomerPortal));
    }

    @Given("user clicks create a new customer button")
    public void userClicksCreateANewCustomerButton() {

        WDController.waitAndClick(eump.employeeCreateCustomerPortal);
    }

    @When("user enter search {string} number")
    public void userSearchNumber(String ssnSearch) {
        WDController.waitAndSendText(eump.searchSsnTextbox,ssnSearch);
    }

    @And("user clicks send button")
    public void userClicksSendButton() {
        WDController.waitAndClick(eump.searchButton,5);
    }


    @Then("user checks registered ssn equality with search {string}")
    public void userChecksRegisteredSsnEqualityWithSearch(String searchSsn) {

        Assert.assertEquals(searchSsn,WDController.waitAndGetText(eump.ssnTextbox,30));
    }






    @And("user clicks back button")
    public void userClicksBackButton() {

        //    WDController.waitAndClickElement(eump.backButton,5);

    }



}
