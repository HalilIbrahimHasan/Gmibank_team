package stepDefs;

import io.cucumber.java.en.Then;
import utilities.WDController;

import static stepDefs.BaseSteps.cpe;

public class CommonSteps {

    @Then("validate toast {string}")
    public void validate_toast(String toastMessage) {
//        WDController.validateToaster(toastMessage);
    }

    @Then("user logs out")
    public void user_logs_out() {
       WDController.closeDriver();
    }
}
