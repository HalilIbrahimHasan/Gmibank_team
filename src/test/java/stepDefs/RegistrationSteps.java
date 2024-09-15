package stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.WDController;

import java.time.Duration;

import static stepDefs.BaseSteps.registrant;
import static stepDefs.BaseSteps.rp;
import static utilities.TxtWriter.txtRegistrantWriter;

public class RegistrationSteps {





   Faker faker = new Faker();




    @Given("user navigates to lending page")
    public void user_navigates_to_lending_page() {
        WDController.getDriver().get(ConfigurationReader.getProperty("qa_url"));
    }
    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page() {

        WDController.waitAndClick(rp.loginDropdown);

        WDController.waitAndClick(rp.registerNavigation);


    }
    @Given("user provides {string} number")
    public void user_provides_number(String ssn) {

        ssn =  faker.idNumber().ssnValid();

        WDController.waitAndSendTextAndSubmit(rp.ssnTextbox, ssn);

        registrant.setSsn(ssn);
    }
    @Given("user provides {string}")
    public void user_provides(String firstname) {

        firstname = faker.name().firstName();
        WDController.waitAndSendText(rp.firstnameTextbox, firstname);

        registrant.setFirstName(firstname);
    }
    @When("user provides {string} of user")
    public void user_provides_of_user(String lastname) {

        lastname = faker.name().lastName();
        WDController.waitAndSendText(rp.lastnameTextbox, lastname);

          registrant.setLastName(lastname);
    }
    @Then("user provides {string} info")
    public void user_provides_info(String address) {

        address = faker.address().fullAddress();
        WDController.waitAndSendText(rp.addressTextbox, address);
          registrant.setAddress(address);
    }
    @Then("user provides mobile {string} number")
    public void user_provides_mobile_number(String phone) {

        phone = faker.phoneNumber().cellPhone();
        WDController.waitAndSendText(rp.mobilephoneTextbox, phone);
       registrant.setPhoneNumber(phone);
    }
    @Then("user provides unique {string}")
    public void user_provides_unique(String username) {

        username = registrant.getFirstName() + registrant.getLastName();
        WDController.waitAndSendText(rp.usernameTextbox, username);
         registrant.setUserName(username);
    }

    @Then("user gives a valid {string} id")
    public void user_gives_a_valid_id(String email) {

        email = registrant.getFirstName()+registrant.getLastName()+ "@gmail.com";
        WDController.waitAndSendText(rp.emailTextbox, email);
       registrant.setEmail(email);
    }
    @When("user sends {string}")
    public void user_sends(String password) {
        password = "As!"+ faker.internet().password(8, 20,true, true );
        WDController.waitAndSendText(rp.firstPasswordTextbox, password);
        registrant.setPassword(password);
    }
    @Then("user provides same {string}")
    public void user_provides_same(String passCon) {
        WDController.waitAndSendText(rp.newPasswordTextbox, registrant.getPassword());
    }
    @Then("user valides applicant registration")
    public void user_valides_applicant_registration() {

        WDController.waitAndClick(rp.registerButton);
    }
    @Then("user saves the applicant info")
    public void user_saves_the_applicant_info() {

        Assert.assertTrue(WDController.waitForClickablility(Duration.ofSeconds(5),rp.successMessage));
        txtRegistrantWriter("NewUsers.txt", registrant);
    }

    @Then("user validates ssn")
    public void user_validates_ssn() {

        String value = WDController.waitAndGetText(rp.ssnInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Ssn is invalid.");
    }

    @Then("user validates  invalid ssn")
    public void user_validates_invalid_ssn() {

        String value = WDController.waitAndGetText(rp.ssnInvalidFeedback, 5);
        Assert.assertEquals(value,"Ssn is invalid.");
    }

    @Then("user validates first name")
    public void userValidatesFirstName() {

        String value = WDController.waitAndGetText(rp.firstnameInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Please enter your first name.");
    }

    @Then("user validates last name")
    public void userValidatesLastName() {

        String value = WDController.waitAndGetText(rp.lastnameInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Please enter your last name.");
    }

    @Then("user validates address")
    public void userValidatesAddress() {

        String value = WDController.waitAndGetText(rp.addressInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Please enter your address.");
    }

    @Then("user validates mobile phone")
    public void userValidatesMobilePhone() {

        String value = WDController.waitAndGetText(rp.mobilephoneInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Your mobile phone number is invalid.");
    }

    @Then("user validates username")
    public void userValidatesUsername() {

        String value = WDController.waitAndGetText(rp.usernameInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Your username is required.");
    }

    @Then("user validates email")
    public void userValidatesEmail() {

        String value = WDController.waitAndGetText(rp.emailInvalidFeedback, 5);
        Assert.assertNotEquals(value,"Your email is invalid.");
    }

    @Given("user provides a {string} with at least seven chars as lowercase")
    public void user_provides_a_with_at_least_seven_chars_as_lowercase(String password) {
        WDController.waitAndSendText(rp.firstPasswordTextbox, password);
        Assert.assertTrue( "The password strength is not matched!", rp.passwordStOne.isDisplayed());
        rp.firstPasswordTextbox.clear();
    }
    @Given("user provides a {string} with seven c  + upper case")
    public void user_provides_a_with_seven_c_upper_case(String password) {
        WDController.waitAndSendText(rp.firstPasswordTextbox, password);
        Assert.assertTrue( "The password strength is not matched!", rp.passwordStTwo.isDisplayed());
        rp.firstPasswordTextbox.clear();
    }
    @Given("user provides a {string} with seven c + up c  & num")
    public void user_provides_a_with_seven_c_up_c_num(String password) {
        WDController.waitAndSendText(rp.firstPasswordTextbox, password);
        Assert.assertTrue( "The password strength is not matched!", rp.passwordStThree.isDisplayed());
        rp.firstPasswordTextbox.clear();
    }
    @Given("user provides a {string} with seven c + up c  num & special char")
    public void user_provides_a_with_seven_c_up_c_num_special_char(String password) {
        WDController.waitAndSendText(rp.firstPasswordTextbox, password);
        Assert.assertTrue( "The password strength is not matched!", rp.passwordStFour.isDisplayed());
        rp.firstPasswordTextbox.clear();
    }

    @Given("user provides a {string}")
    public void user_provides_a(String password) {

        WDController.waitAndSendText(rp.firstPasswordTextbox, password);

    }
    @Then("user validates {string}")
    public void user_validates(String sLevel) {

      rp.passwordValidation(Integer.parseInt(sLevel));
    }


}
