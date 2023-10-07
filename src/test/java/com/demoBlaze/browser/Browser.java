package com.demoBlaze.browser;

import com.demoBlaze.driver.WebDriverSingleton;
import com.demoBlaze.platform.DemoBlaze;
import org.openqa.selenium.Alert;

public class Browser {
    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public DemoBlaze demoBlaze;
    private Alert alert;

    public Browser()
    {
        demoBlaze = new DemoBlaze();
    }

    public Alert getAlert() {
        alert = WebDriverSingleton.getWebDriver().switchTo().alert();
        return alert;
    }

}
