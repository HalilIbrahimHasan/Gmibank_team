package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;
import utilities.WDController;

import static baseUrls.GMIBaseUrl.setup;
import static stepDefs.BaseSteps.*;

public class Hooks {


    @Before("AA")
    public void setUp()  {

        initPages();


 //       videoRecord = new VideoRecord();
 //       videoRecord.startRecording();


    }

    @Before("@API")
    public void setUpApi(){

        setup();
    }

    @After("@userMan")
    public void tearDown() throws Exception {


        videoRecord.stopRecording();


    }

    @AfterClass
    public static void quitAll() throws Exception {
        WDController.getDriver().quit();

    }



}
