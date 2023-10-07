package com.demoBlaze.pages;

import com.demoBlaze.driver.WebDriverSingleton;
import com.demoBlaze.tests.BaseTest;
import org.openqa.selenium.By;
import java.util.Random;

import static com.demoBlaze.utilities.ElementActions.*;

public class Home extends BaseTest {
  private  By signUpButton  = By.xpath("//a[@id='signin2']");
  private  By logInButton  = By.xpath("//a[@id='login2']");
  private  By cartButton  = By.xpath("//a[@id='cartur']");
  private  By userNameID  = By.xpath("//a[@id='nameofuser']");

  private By laptopCategoryButton = By.xpath("//a[contains(text(),'Laptops')]");
  private By phoneCategoryButton = By.xpath("//a[contains(text(),'Phones')]");
  private By monitorCategoryButton = By.xpath("//a[contains(text(),'Monitors')]");
  private  By countItems  = By.xpath("//div[@id='tbodyid']//p");
  private By randomItem = By.xpath("//div[@id='tbodyid']//a[contains(.,' ')]");



  public void clickOnSignUpButton(){ click(signUpButton);}
  public void clickOnLogInButton(){ click(logInButton);}
  public void clickOnCartButton(){ click(cartButton);}


  public String getUserNameID(){
    return getText(userNameID);
  }
  public void clickOnLaptopCategoryOption(){click(laptopCategoryButton);}

  public void clickOnPhoneCategoryOption(){click(phoneCategoryButton);}
  public void clickOnMonitorCategoryOption(){click(monitorCategoryButton);}

  public boolean isCategoryNotEmpty(){
         return getListOfWebElements(countItems).size()!=0;
  }

  public void clickOnRandomItem(){
    Random random = new Random();
    int noOfItems = getListOfWebElements(randomItem).size();
    int choosingRandomItem = random.nextInt(noOfItems);
    WebDriverSingleton.getWebDriver().findElements(randomItem).get(choosingRandomItem).click();
  }

}
