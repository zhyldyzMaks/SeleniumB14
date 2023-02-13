package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.DepartmentPage;
import com.test.sentrifugo.pages.MainPage;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBaseSentrifugo {

    @Test
    public void validateMessageOfEmpCr() throws InterruptedException {

     //   LoginPage loginPage=new LoginPage(driver);
   //     loginPage.login("EM01","sentrifugo");
        Thread.sleep(2000);
        MainPage mainPage=new MainPage(driver);
        mainPage.clickDepartmentButton();
        DepartmentPage departmentPage=new DepartmentPage(driver);
        departmentPage.validateMessageOfEmployeeCreation("IT","123","Department added successfully.");
        departmentPage.validateInformationFromTable("Information Technology","IT","01/05/2001",
                "Thomas E","America/New_York [EDT]","Orange Blossom");
    }

}
