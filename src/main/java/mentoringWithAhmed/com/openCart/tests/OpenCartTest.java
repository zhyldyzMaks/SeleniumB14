package mentoringWithAhmed.com.openCart.tests;

import mentoringWithAhmed.com.openCart.pages.CustomerPage;
import mentoringWithAhmed.com.openCart.pages.LoginPage;
import mentoringWithAhmed.com.openCart.pages.MainPage;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenCartTest extends TestBaseOpenCart {

    @Parameters({"username","passwrd","num1","num2","num3","num4"})
    @Test
    public void numbersValidate(String userName,String password,String num1,String num2,String num3,String num4){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginButton(userName, password);

        MainPage mainPage=new MainPage(driver);
        mainPage.numbersValidation(driver,num1,num2,num3,num4);
    }

    @Parameters({"fName","lName","eMail","number","psswrd","confirm","expectedMssge"})
    @Test
    public void customerValidation(String fName,String lName,String eMail,String number,String psswrd,
                                   String confrm,String expectedMssge){
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.customerValidation(driver,fName,lName,eMail,number,psswrd,confrm,expectedMssge);
    }
}
