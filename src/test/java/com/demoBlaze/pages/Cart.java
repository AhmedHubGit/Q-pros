package com.demoBlaze.pages;

import com.demoBlaze.tests.BaseTest;
import org.openqa.selenium.By;

import static com.demoBlaze.utilities.ElementActions.click;

public class Cart extends BaseTest {
    private By deleteButton  = By.xpath("//a[contains(text(),'Delete')]");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");


    public void clickOnDeleteButton(){ click(deleteButton);}
    public void clickOnPlaceOrderButton(){ click(placeOrderButton);}
}
