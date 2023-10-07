package com.demoBlaze.tests;

import com.demoBlaze.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class HooksHandler extends BaseTest {
    @Before
    public void setup() throws InterruptedException {
        driver = WebDriverSingleton.getDriverSingleton();
        driver.setDriverCapabilities("edge");
        driver.resetCache();
        driver.maximizeWindow();
        driver.navigateTo("http://demoblaze.com");
    }

    @After
    public void tirdown(){
        driver.close();
    }

}
