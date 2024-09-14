package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.WDController;

public class Hooks {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

        WDController.sleep(2000);
        WDController.getDriver().quit();
    }
}
