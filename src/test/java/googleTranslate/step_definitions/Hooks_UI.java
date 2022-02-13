package googleTranslate.step_definitions;

import googleTranslate.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks_UI {


    @Before
    public void setUpDriver(){

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"img/png", scenario.getName());
        }


        Driver.closeDriver();
    }
}
