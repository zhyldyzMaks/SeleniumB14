package seleniumHW4.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import seleniumHW4.pages.TC1Page;

public class TC1Test extends HWTestBaze {

    @Parameters({"name", "psswrd", "patientName", "phoneNumber", "ssn", "dob"})
    @Test
    public void loginValidation(String name, String psswrd, String patientName,
                                String phoneNumber, String ssn, String dob) throws InterruptedException {
        TC1Page tc1Page = new TC1Page(driver);
        tc1Page.loginPage(driver, name, psswrd);
        tc1Page.patientValidation(driver, patientName, phoneNumber, ssn, dob);

    }

//    @Parameters({"name", "psswrd", "message"})
//    @Test
//    public void editValidation(String name, String psswrd,String message) {
//        TC1Page tc1Page = new TC1Page(driver);
//        tc1Page.loginPage(driver, name, psswrd);
//        tc1Page.editValidation(message);
//
//
//    }
}