package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPageBlaze {

    public MainPageBlaze(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Laptops")
    WebElement laptops;

    @FindBy(linkText = "Phones")
    WebElement phones;

    @FindBy(id = "signin2")
    WebElement signInButton;

    @FindBy(id = "sign-username")
    WebElement userName;

    @FindBy(id = "sign-password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signIn;


    public void clickLaptop(){
        laptops.click();
    }

    public void clickPhones(){
        phones.click();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void setUserName(String name){
        userName.sendKeys(name);
    }
    public void setPassword(String psswrd){
        password.sendKeys(psswrd);
    }

    public void setSignInButton(){
        signIn.click();
    }

}
