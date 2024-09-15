package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.WDController;

import java.time.Duration;

import static stepDefs.BaseSteps.lp;

public class LoginSteps {


    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {

        WDController.getDriver().get(ConfigurationReader.getProperty("qa_url"));
    }

    @Given("user provides {string} and {string}")
    public void user_provides_and(String username, String password) {

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.loginDropdown));
        WDController.waitAndClick(lp.loginDropdown);

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.signInButton));
        WDController.waitAndClick(lp.signInButton);

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.username));
        WDController.waitAndSendText(lp.username, username);


        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.password));
        WDController.waitAndSendText(lp.password, password);

    }

    @Then("user validates user login")
    public void user_validates_user_login() {

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.loginButton));
        WDController.waitAndClick(lp.loginButton);
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.navigatedPage));
    }

    @When("user clicks on the {string} button")
    public void user_clicks_on_the_button() {
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.cancelButton));
        WDController.waitAndClick(lp.cancelButton);

    }
    @Then("user should be back to the lending page")
    public void userShouldBeBackToTheLendingPage() {
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.homePage));

    }


    @Given("user clicks on account menu")
    public void user_clicks_on_account_menu() {
        lp = new LoginPage();
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.loginDropdown));
        WDController.waitAndClick(lp.loginDropdown);
    }
    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.signInButton));
        WDController.waitAndClick(lp.signInButton);
    }
    @When("user provides login {string}")
    public void user_provides_login(String username) {
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.username));
        WDController.waitAndSendText(lp.username, username);
    }

    @When("user provides the  login {string}")
    public void user_provides_the_login(String password) {
        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),lp.password));
        WDController.waitAndSendText(lp.password, password);
    }

    @When("user clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        WDController.waitAndClick(lp.cancelButton);
    }
    @Then("user validates the cancellation")
    public void user_validates_the_cancellation() {
        String signInValidation = WDController.waitAndGetText(lp.signInValidation, 5);

        Assert.assertNotEquals(signInValidation, "Sign in");

    }

}




