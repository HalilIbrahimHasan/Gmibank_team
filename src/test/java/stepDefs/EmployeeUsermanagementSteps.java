package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

 //       WDController.waitAndClick(eump.employeeCreateCustomerPortal);

    }

    @Then("user clicks back button")
    public void userClicksBackButton() {

    //    WDController.waitAndClickElement(eump.backButton,5);

    }


}
