package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2")
    WebElement laptopName;

    @FindBy(xpath = "//h3")
    WebElement laptopPrice;

    @FindBy(id = "more-information")
    WebElement moreInformation;


    public void validationProductInfo(String expectedLaptop,String expectedPrice,String expectedInformation){
        Assert.assertEquals(BrowserUtils.getText(laptopName), expectedLaptop);
        Assert.assertEquals(BrowserUtils.getText(laptopPrice),expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(moreInformation),expectedInformation);
    }
}
