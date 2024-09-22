package stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.WDController;

import java.time.Duration;

import static stepDefs.BaseSteps.*;

public class EmployeeUsermanagementSteps {

    Faker faker = new Faker();

    @Then("user validates customer management page")
    public void userValidatesCustomerManagementPage() {

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5), eump.createANewCustomer));
    }

    @Given("user clicks create a new customer button")
    public void userClicksCreateANewCustomerButton() {

        WDController.waitAndClick(eump.createANewCustomer);
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
        Assert.assertEquals(searchSsn,WDController.waitAndGetValue(eump.ssnTextbox,10));
    }

    @And("user clicks back button")
    public void userClicksBackButton() {
           WDController.waitAndClickElement(eump.backButton,5);
    }


    @And("user enters address information")
    public void userChecksAddressInformation() {
        WDController.wait(10);
        eump.addressTextbox.clear();
        String street = faker.address().streetAddress();
        WDController.waitAndSendText(eump.addressTextbox, street);
    }

    @And("user enters city information")
    public void userChecksCityInformation() {
        String city = faker.address().city();
        WDController.waitAndSendText(eump.cityTextbox, city);
    }

    @And("user enters country information")
    public void userChecksCountryInformation() {
        WDController.waitAndClick(eump.countryDropdown);
        WDController.wait(10);
        WDController.waitAndSendTextAndSubmit(eump.countryDropdown, "USA");
    }

    @And("user enters state information")
    public void userChecksStateInformation() {
        String state = faker.address().state();
        WDController.waitAndSendText(eump.stateTextbox, state);
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {
    }


    @And("user clicks on sign out button")
    public void userClicksOnSignOutButton() {
        WDController.waitAndClick(eump.signOutButton);
    }

    @Given("user checks all customer information")
    public void userGetAllCustomerInformation() {
    //    eump.checkAccountInformation();
    }

    @And("user checks view button functionality")
    public void userChecksViewButtonFunctionality() {
        eump.checkViewButtonFunctionality();
    }
}
