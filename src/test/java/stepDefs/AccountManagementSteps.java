package stepDefs;

import io.cucumber.java.en.*;
import pojos.Account;
import utilities.WDController;

import static stepDefs.BaseSteps.*;

public class AccountManagementSteps {

    @Then("user gives {string} and {string}")
    public void user_gives_and(String header, String input) {
        WDController.headerValueTextIN(header,input);
        account.setAccountValues(header, input);
    }
    @When("user selects {string}")
    public void user_selects(String dropdownItem) {
       WDController.selectAnItemFromDropdown(amp.accountTypeDropdown, dropdownItem);
        account.setAccountType(dropdownItem);
    }
    @When("user chooses {string}")
    public void user_chooses(String status) {
        WDController.selectAnItemFromDropdown(amp.accountStatus, status);
        account.setAccountStatus(status);
    }

}
