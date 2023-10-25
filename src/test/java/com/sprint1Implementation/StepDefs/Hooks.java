package com.sprint1Implementation.StepDefs;

import com.sprint1Implementation.utilities.ConfigurationReader;
import com.sprint1Implementation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before("@ui")
    public void setUp() {
        // we put a logic that should apply to every scenario
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //added line to open URL -mk
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}
