package com.demoBlaze.pages;

import org.openqa.selenium.By;

import static com.demoBlaze.utilities.ElementActions.click;
import static com.demoBlaze.utilities.ElementActions.type;

public class Signup {



    private By username = By.xpath("//input[@id='sign-username']");
    private   By password = By.xpath("//input[@id='sign-password']");
    private   By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");

    public void enterUserName(String userName){ type(username,userName);}
    public void enterPassword(String passWord){ type(password,passWord);}
    public void clickOnSignUpButton(){ click(signUpButton);}

    public void SignUp(String userName,String passWord)
    {
        enterUserName(userName);
        enterPassword(passWord);
        clickOnSignUpButton();
    }

}
