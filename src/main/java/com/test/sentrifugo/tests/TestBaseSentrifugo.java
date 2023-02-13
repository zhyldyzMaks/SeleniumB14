package com.test.sentrifugo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseSentrifugo {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("sentrifugourl"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess())
        BrowserUtils.getScreenShot(driver,"sentrifugo");

    }//driver.quit();
}
