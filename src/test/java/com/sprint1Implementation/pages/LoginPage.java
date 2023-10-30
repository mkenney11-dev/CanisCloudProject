package com.sprint1Implementation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user")
    public WebElement userNameField;

    @FindBy(xpath = "//*[@id = 'password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id = 'submit-form']")
    public WebElement logInButton;



    public void login (String username, String password){
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();
    }

}
