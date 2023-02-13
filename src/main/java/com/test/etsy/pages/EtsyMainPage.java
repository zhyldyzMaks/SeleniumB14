package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyMainPage {
    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    WebElement searchBox;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allCasesHeader;


    public boolean searchCase(String itemName,String thirteen,String iphone,String iphoneCase){
        searchBox.sendKeys(itemName, Keys.ENTER);
        for (WebElement header:allCasesHeader){
            String text = BrowserUtils.getText(header).toLowerCase();
            if (text.contains(thirteen)|| text.contains(iphone)|| text.contains(iphoneCase));
            return true;
           //Assert.assertTrue(text.contains(thirteen)||text.contains(iphone)|| text.contains(iphoneCase));
        }return false;


    }
}
