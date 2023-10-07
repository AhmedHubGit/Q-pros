package com.demoBlaze.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/demoBlaze/tests/feature/completeSuccessfulCheckoutWithRandomItem.feature",
        glue = {"com.demoBlaze.tests"},
        tags = ""
)
public class TrialRunner extends AbstractTestNGCucumberTests {

}
