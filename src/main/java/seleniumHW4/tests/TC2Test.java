package seleniumHW4.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import seleniumHW4.pages.TC1Page;
import seleniumHW4.pages.TC2Page;

public class TC2Test extends HWTestBaze{

    @Parameters({"name","psswrd","patientName","message"})
    @Test
    public void editValidation(String name,String psswrd,String patientName,String message){
        TC1Page tc1Page=new TC1Page(driver);
        tc1Page.loginPage(driver,name,psswrd);
        TC2Page tc2Page=new TC2Page(driver);
        tc2Page.editValidation(driver,message);
    }



}
