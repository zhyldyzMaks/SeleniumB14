package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPageBlaze {

    public LaptopPageBlaze(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allLaptops;

    @FindBy(xpath = "//a[contains(text(),'MacBook Pro')]")
    WebElement macBook;



    public void validateAllLaptops(WebDriver driver,String brand){
        BrowserUtils.scrollIntoView(driver,macBook);

        for (WebElement laptop:allLaptops){
            if (BrowserUtils.getText(laptop).equals(brand)){
                laptop.click();
                break;
            }
        }

    }
}
