package stepDefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegistrationPage;
import utilities.WDController;

import java.time.Duration;

import static utilities.WDController.clickByText;

public class RegisterSteps {

    RegistrationPage rp = new RegistrationPage();



    @Given("user navigates to dropdown menu")
    public void user_navigates_to_dropdown_menu() {
        WDController.clickElement(rp.loginDropdown);
    }
    @Given("user clicks on {string}")
    public void user_clicks_on(String text) {
        WDController.clickByText(text);
    }
    @Given("user provides a text {string}")
    public void user_provides_a_text(String string) {

    }




}
