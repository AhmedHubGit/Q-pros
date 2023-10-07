package com.demoBlaze.tests;

import com.demoBlaze.browser.Browser;
import com.demoBlaze.driver.WebDriverSingleton;

public class BaseTest {
    public static   WebDriverSingleton driver;
    public static Browser browser = new Browser();

    public BaseTest(){
        driver = WebDriverSingleton.getDriverSingleton();
    }
}
