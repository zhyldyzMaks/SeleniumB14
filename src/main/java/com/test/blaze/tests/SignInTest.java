package com.test.blaze.tests;

import com.test.blaze.pages.MainPageBlaze;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends TestBaseBlaze{

    @Test
    public void signInTest() throws InterruptedException {

        MainPageBlaze mainPageBlaze=new MainPageBlaze(driver);

        mainPageBlaze.clickSignInButton();
        mainPageBlaze.setUserName("Privet");
        mainPageBlaze.setPassword("Strana!");
        mainPageBlaze.setSignInButton();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Sign up successful.");
        alert.accept();

    }
}
