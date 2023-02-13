package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BackGroundPage {

    public BackGroundPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@value='Add Record']")
    WebElement addButton;

    @FindBy(xpath = "//span[contains(text(),'Select Employee/Candidate')]")
    WebElement selectBox;

    @FindBy(xpath = "//span[contains(text(),'Harris, Human Resource')]")
    WebElement harris;

    @FindBy(xpath = "//p//span")
    List<WebElement> allInfo;

    @FindBy(id = "checktype-2")
    WebElement creditBox;

    @FindBy(xpath = "//div[@class='no-data']")
    WebElement noAgency;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'You cannot send an employee for background')]")
    WebElement message;

    public void validateAllInfo(WebDriver driver,String name, String email, String number, String address, String status,String expectedAgent,String expectedMesaage){
        addButton.click();
        selectBox.click();
        harris.click();

        List<String> expectedInfo= Arrays.asList(name,email,number,address,status);
        for (int i =0; i<allInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expectedInfo.get(i));
        }
        BrowserUtils.scrollIntoView(driver,creditBox);

        creditBox.click();
        Assert.assertEquals(BrowserUtils.getText(noAgency),expectedAgent);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMesaage);

    }

}
