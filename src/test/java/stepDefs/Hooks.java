package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.VideoRecord;
import utilities.WDController;

import static stepDefs.BaseSteps.initPages;

public class Hooks {

    VideoRecord videoRecord =null;
    @Before
    public void setUp() throws Exception {

        initPages();

 //       videoRecord = new VideoRecord();
 //       videoRecord.startRecording();

    }

    @After
    public void tearDown() throws Exception {

 //       videoRecord.stopRecording();
 //       WDController.getDriver().quit();

    }

}
