package com.demoBlaze.tests.stepDef;

import com.demoBlaze.driver.WebDriverSingleton;
import com.demoBlaze.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MyStepdefs extends BaseTest {

    @Given("user will click on signup button")
    public void userWillClickOnSignupButton() {
        browser.demoBlaze.home.clickOnSignUpButton();
    }
    @And("user will enter {string} and {string} and click on sign up button")
    public void userWillEnterAndAndClickOnSignUpButton(String username, String password) {
        browser.demoBlaze.signup.SignUp(username,password);
    }

    @Then("alert will appear with message {string} and validate that it was successfully created")
    public void alertWillAppearWithMessageAndValidateThatItWasSuccessfullyCreated(String alertMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(browser.getAlert().getText(), alertMessage);
    }


    @When("user will click on login button")
    public void userWillClickOnLoginButton() {
        browser.demoBlaze.home.clickOnLogInButton();
    }

    @And("user will enter {string} and {string} and click on login button")
    public void userWillEnterAndAndClickOnLoginButton(String username, String password){
        browser.demoBlaze.login.login(username,password);
    }

    @Then("validate on the {string} is shown as the logged in user")
    public void validateOnTheIsShownAsTheLoggedInUser(String username) throws InterruptedException {
        Thread.sleep(3000);
        driver.refreshCurrentUrl();
        Thread.sleep(3000);
        Assert.assertTrue(browser.demoBlaze.home.getUserNameID().contains(username));
    }

    @When("clicking on laptops category lots of list items will be shown")
    public void clickingOnLaptopsCategoryLotsOfListItemsWillBeShown() {
        browser.demoBlaze.home.clickOnLaptopCategoryOption();
    }

    @When("clicking on mobiles category lots of list items will be shown")
    public void clickingOnMobilesCategoryLotsOfListItemsWillBeShown() {
   browser.demoBlaze.home.clickOnPhoneCategoryOption();
    }

    @When("clicking on monitors category lots of list items will be shown")
    public void clickingOnMonitorsCategoryLotsOfListItemsWillBeShown() {
        browser.demoBlaze.home.clickOnMonitorCategoryOption();
    }

    @Then("validate that selected category has items")
    public void validateThatSelectedCategoryHasItems(){
        Assert.assertTrue(browser.demoBlaze.home.isCategoryNotEmpty());
    }

    @When("random item is selected")
    public void randomItemIsSelected() throws InterruptedException {
        browser.demoBlaze.home.clickOnRandomItem();
        Thread.sleep(7000);
    }

    @And("click on add to cart button")
    public void clickOnAddToCartButton() {
        browser.demoBlaze.product.clickOnSignUpButton();
    }

    @Then("alert will appear with message {string} that item is added successfully")
    public void alertWillAppearWithMessageThatItemIsAddedSuccessfully(String Message) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(browser.getAlert().getText(), Message);
    }

    @When("clicking on cart button in the home page")
    public void clickingOnCartButtonInTheHomePage() {
        browser.demoBlaze.home.clickOnCartButton();
    }

    @And("removing the item added from the cart page")
    public void removingTheItemAddedFromTheCartPage() {
        browser.demoBlaze.cart.clickOnDeleteButton();
    }

    @And("clicking on place order button")
    public void clickingOnPlaceOrderButton() {
        browser.demoBlaze.cart.clickOnPlaceOrderButton();
    }

    @And("fill the place order form by entering {string} , {string} , {string} , {string} , {string} and {string}")
    public void fillThePlaceOrderFormByEnteringAnd(String name, String country, String city, String creditCard, String Month, String Year) {
        browser.demoBlaze.placeOrder.PlaceOrder(name,country,city,creditCard,Month,Year);
    }

    @Then("Click ok button")
    public void clickOkButton() {
        browser.demoBlaze.placeOrder.clickOnOkButton();
        WebDriverSingleton.close();

    }
}
