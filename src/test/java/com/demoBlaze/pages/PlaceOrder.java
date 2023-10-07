package com.demoBlaze.pages;

import com.demoBlaze.tests.BaseTest;
import org.openqa.selenium.By;

import static com.demoBlaze.utilities.ElementActions.click;
import static com.demoBlaze.utilities.ElementActions.type;

public class PlaceOrder extends BaseTest {
    private By nameTextField  = By.xpath("//input[@id='name']");
    private By countryTextField  = By.xpath("//input[@id='country']");
    private By cityTextField  = By.xpath("//input[@id='city']");
    private By creditCardTextField  = By.xpath("//input[@id='card']");
    private By monthTextField  = By.xpath("//input[@id='month']");
    private By yearTextField  = By.xpath("//input[@id='year']");
    private By purchaseButton  = By.xpath("//button[contains(text(),'Purchase')]");
    private By okButton  = By.xpath("//button[contains(text(),'OK')]");

    public void enterName(String Name){ type(nameTextField,Name);}
    public void enterCountry(String Country){ type(countryTextField,Country);}
    public void enterCity(String City){ type(cityTextField,City);}
    public void enterCreditCardNumbers(String CreditCard){ type(creditCardTextField,CreditCard);}
    public void enterMonth(String Month){ type(monthTextField,Month);}
    public void enterYear(String Year){ type(yearTextField,Year);}
    public void clickOnPurchaseButton(){ click(purchaseButton);}
    public void clickOnOkButton(){ click(okButton);}

    public void PlaceOrder(String Name,String Country,String City,String CreditCard,String Month,String Year)
    {
        enterName(Name);
        enterCountry(Country);
        enterCity(City);
        enterCreditCardNumbers(CreditCard);
        enterMonth(Month);
        enterYear(Year);
        clickOnPurchaseButton();
    }

}
