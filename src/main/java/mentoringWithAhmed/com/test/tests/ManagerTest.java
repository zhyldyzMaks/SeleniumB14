package mentoringWithAhmed.com.test.tests;

import mentoringWithAhmed.com.test.pages.CustomerPage;
import mentoringWithAhmed.com.test.pages.LoginPage;
import mentoringWithAhmed.com.test.pages.ManagerPage;
import org.testng.annotations.Test;

public class ManagerTest extends TestBaseBank{

   /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE and click OK
10-Click Customers Button
11-Validate your firstname,lastName,PostCode and Account Number
12-driver.quit
13-Proud of yourself
 */

    @Test
    public void managerValidation(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickManager();
        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.customerValidation("Harrry","Potter","60056",driver);
    }

    @Test
    public void customerValidation() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickCustomer();
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerValidation("500","300");


    }

}
