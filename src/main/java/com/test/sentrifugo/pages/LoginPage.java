package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNG.DataProviderAllData;
import utils.BrowserUtils;

public class LoginPage {

    //We store our webElements and methods here from LoginPage
    //Whenever we create any page we must initialize our elements with Constructor

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(id= "password")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy(id="usernameerror")
    WebElement userNameErrorMessage;

    @FindBy(id="pwderror")
    WebElement passwordErrorMessage;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String title(WebDriver driver){
        return driver.getTitle().trim();
    }

    public String userNameErrorMessage(){
        return BrowserUtils.getText(userNameErrorMessage);
    }

    public String passwordErrorMessage(){
        return BrowserUtils.getText(passwordErrorMessage);
    }

    public String colorOfUsernameErrorMessage(){
        return userNameErrorMessage.getCssValue("color").trim();
    }

    public String colorOfPasswordErrorMessage(){
        return passwordErrorMessage.getCssValue("color").trim();
    }









}
