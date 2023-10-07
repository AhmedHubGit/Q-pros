package com.demoBlaze.pages;

import com.demoBlaze.tests.BaseTest;
import org.openqa.selenium.By;
import static com.demoBlaze.utilities.ElementActions.*;

public class Product extends BaseTest {
    private By addToCartButton  = By.xpath("//a[contains(text(),'Add to cart')]");

    public void clickOnSignUpButton(){ click(addToCartButton);}

}
