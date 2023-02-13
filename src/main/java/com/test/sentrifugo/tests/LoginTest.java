package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNG.DataProviderAllData;
import utils.ConfigReader;

public class LoginTest extends TestBaseSentrifugo {

    @Test(priority = 2)
    public void validatePositiveLogin(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("sentrifugousername"),ConfigReader.readProperty("sentrifugopassword"));
        Assert.assertEquals(loginPage.title(driver),"Sentrifugo - Open Source HRMS");
        Assert.assertEquals(driver.getTitle().trim(),"Sentrifugo - Open Source HRMS");
    }

    @Test(priority = 1)
    public void validateNegativeLogin(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("","");
        Assert.assertEquals(loginPage.userNameErrorMessage(),"Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(),"Please enter password.");
        Assert.assertEquals(loginPage.colorOfUsernameErrorMessage(),"rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.colorOfPasswordErrorMessage(),"rgba(255, 0, 0, 1)");
    }

    @Test(dataProvider = "loginFunction",dataProviderClass = DataProviderData.class)
    public void validateAllSuccessfullLogin(String username1,String password1){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username1,password1);
        Assert.assertEquals(loginPage.title(driver),"Sentrifugo - Open Source HRMS");
        driver.quit();
    }


}
