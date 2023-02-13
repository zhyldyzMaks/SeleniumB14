package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.BackGroundPage;
import com.test.sentrifugo.pages.MainPage;
import org.testng.annotations.Test;

public class BackGroundTest extends TestBaseSentrifugo {

    @Test
    public void validationInfoTest(){
     //   LoginPage loginPage=new LoginPage(driver);
     //   loginPage.login("EM01","sentrifugo");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickBackgroundCheck();
        BackGroundPage empscreeningPage=new BackGroundPage(driver);
        empscreeningPage.validateAllInfo(driver,"Harris","harris@example.com","4785236981",
                "Trl,\n" +
                        "Orlando,\n" +
                        "Florida,\n" +
                        "United States\n" +
                        "- 48748","Active","No agency","You cannot send an employee for " +
                        "background check as the screening configurations are not set yet.");
    }


}

