package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethods {

    @BeforeMethod
    public void before(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @AfterMethod
    public void after(){
        System.out.println("AfterMethod");
    }

}
