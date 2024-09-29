package stepDefs;

import io.cucumber.java.en.Then;
import utilities.TxtWriter;
import utilities.WDController;

import java.util.ArrayList;

import static stepDefs.BaseSteps.*;
import static utilities.ReadTxtFile.readAccounts;
import static utilities.TxtWriter.accountWriter;


public class CustomerManagementSteps {

    @Then("user searches customer by {string}")
    public void user_searches_customer_by(String ssn) {

        WDController.headerValueTextIN(ssn, registrant.getSsn());
    }


    @Then("user provides the user {string} again")
    public void user_provides_the_user_again(String email) {
      WDController.headerValueTextIN(email, registrant.getEmail());
    }
    @Then("user provides {string} again")
    public void user_provides_again(String phone) {
        WDController.headerValueTextIN(phone, "202-372-3928");
    }


    @Then("user selects accounts")
    public void user_selects_accounts() {
        accounts = readAccounts("Accounts.txt");
        cmp.selectAccounts(accounts);


    }
}
