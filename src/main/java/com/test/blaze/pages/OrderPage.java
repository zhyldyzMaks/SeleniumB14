package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement fName;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement citY;

    @FindBy(xpath = "//input[@id='card']")
    WebElement carD;

    @FindBy(xpath = "//input[@id='month']")
    WebElement monTH;

    @FindBy(xpath = "//input[@id='year']")
    WebElement yeaR;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement thankYouMessage;

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement okButton;

    public void createOrder(String name,String cntry, String city,String card,String month, String year,
                            String thankYM,WebDriver driver,String expectedURL) throws InterruptedException {
        fName.sendKeys(name);
        country.sendKeys(cntry);
        citY.sendKeys(city);
        carD.sendKeys(card);
        monTH.sendKeys(month);
        yeaR.sendKeys(year);
        purchaseButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(thankYouMessage),thankYM);
        okButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
}
