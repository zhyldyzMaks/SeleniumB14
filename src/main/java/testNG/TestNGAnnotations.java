package testNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        //is used to set up Chrome browser properties(setProperty ...)
        //you can delete cookies
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        //is used to launch your browser
        //WebDriver driver=DriverHelper.getDriver();
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
        //navigate to the website
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        //it runs before every test annotation
        //it is good to setup automation and navigation
    }
    @Test
    public void test1(){
        System.out.println("test1");
        //it executes the implementation
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        //it runs after every test annotation
        //it is good for ScreenShot, driver.quit, driver.close
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
   @AfterSuite
    public void afterSuite(){
       System.out.println("After Suite");
       
   }


}
