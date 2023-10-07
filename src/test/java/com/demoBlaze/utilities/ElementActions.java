package com.demoBlaze.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.demoBlaze.driver.WebDriverSingleton.getWebDriver;
import static org.testng.Assert.fail;

public class ElementActions {

    public static void click(By elementLocator){
        WebDriver driver = getWebDriver();
        locateElement(elementLocator);
        try {
            getExplicitWait().until(ExpectedConditions.elementToBeClickable(elementLocator));
        }catch (TimeoutException toe){
            System.out.println(toe.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            new Actions(driver).moveToElement(driver.findElement(elementLocator)).perform();
            driver.findElement(elementLocator).click();
        } catch (Exception exception) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[arguments.length - 1].click();",
                        driver.findElement(elementLocator));
            } catch (Exception rootCauseException) {
                rootCauseException.initCause(exception);
                System.out.println(rootCauseException.getMessage());
                fail("Couldn't click on the element:" + elementLocator, rootCauseException);
            }
        }
    }

    public static void type(By elementLocator, String text, boolean clearBeforeTyping) {
        WebDriver driver = getWebDriver();
        locateElement(elementLocator);
        try {
            // Clear before typing condition
            if (!driver.findElement(elementLocator).getAttribute("value").isBlank() && clearBeforeTyping) {
                driver.findElement(elementLocator).clear();
                driver.findElement(elementLocator).sendKeys(text);

                if (!driver.findElement(elementLocator).getAttribute("value").equals(text)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + text + "')",
                            driver.findElement(elementLocator));
                }
            } else {
                driver.findElement(elementLocator).sendKeys(text);

                if (!driver.findElement(elementLocator).getAttribute("value").contains(text)) {
                    String currentValue = driver.findElement(elementLocator).getAttribute("value");
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].setAttribute('value', '" + currentValue + text + "')",
                            driver.findElement(elementLocator));
                }
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public static void type(By elementLocator, String text) {
        type(elementLocator, text, true);
    }

    public static String getText(By elementLocator) {
        WebDriver driver = getWebDriver();
        locateElement(elementLocator);
        try {
            String text = driver.findElement(elementLocator).getText();
            return text;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<String> getListOfText(By locator){
        WebDriver driver = getWebDriver();
        locateElements(locator);
        try {
            return driver.findElements(locator).stream().map(e->e.getText())
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getAttributeValue(By elementLocator, String attributeName){
        WebDriver driver = getWebDriver();
        locateElement(elementLocator);
        try {
            String attributeValue = driver.findElement(elementLocator).getAttribute(attributeName);
            return attributeValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void locateElement(By elementLocator){
        WebDriver driver = getWebDriver();
        try {
            getExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
                    driver.findElement(elementLocator));
            if (!driver.findElement(elementLocator).isDisplayed()) {
                System.out.println("[ " + elementLocator.toString() + " ] is not Displayed");
            }
        }catch (TimeoutException toe){
            System.out.println(toe.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void locateElements(By elementLocator){
        try {
            getExplicitWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
        }catch (TimeoutException toe){
            System.out.println(toe.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<WebElement> getListOfWebElements(By locator){
        WebDriver driver = getWebDriver();
        locateElements(locator);
        return driver.findElements(locator);
    }

    public static WebDriverWait getExplicitWait(){
        WebDriver driver = getWebDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    public static void implicitWait(){
        WebDriver driver = getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
    }
}


