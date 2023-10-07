package com.demoBlaze.pages;

import org.openqa.selenium.By;

import static com.demoBlaze.utilities.ElementActions.*;

public class Login {

    private   By username = By.xpath("//input[@id='loginusername']");
    private   By password = By.xpath("//input[@id='loginpassword']");
    private   By loginButton = By.xpath("//button[contains(text(),'Log in')]");

public void enterUserName(String userName){ type(username,userName);}
public void enterPassword(String passWord){ type(password,passWord);}
public void clickOnLoginButton(){ click(loginButton);}

public void login(String userName,String passWord)
{
    enterUserName(userName);
    enterPassword(passWord);
    clickOnLoginButton();
}

}
