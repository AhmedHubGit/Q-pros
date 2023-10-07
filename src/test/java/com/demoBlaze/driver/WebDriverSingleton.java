package com.demoBlaze.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;
    private static WebDriverSingleton webDriverSingleton = null;

    public static WebDriverSingleton getDriverSingleton(){
        if (webDriverSingleton == null)
            webDriverSingleton = new WebDriverSingleton();
        return webDriverSingleton;
    }

    public void setDriverCapabilities(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("edge")) {
            webDriver = new EdgeDriver();
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public void refreshCurrentUrl() {
        webDriver.navigate().refresh();
    }

    public void resetCache() throws InterruptedException {
        webDriver.manage().deleteAllCookies();
        //TODO: remove thread.sleep
        Thread.sleep(7000);
    }

    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public static void close() {
        if (isNotNull(getWebDriver())) {
            getWebDriver().quit();
        }
    }
    public static Boolean isNotNull(Object object){
        return object != null;
    }

    public static void locateElements(By elementLocator){
       webDriver.findElements(By.xpath(String.valueOf(elementLocator)));
    }

}
