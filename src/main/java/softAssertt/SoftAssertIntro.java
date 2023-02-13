package softAssertt;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIntro {

    public int getSum(int num1, int num2){
        return num1+num2;
    }
    @Test
    public void test(){
        Assert.assertEquals(getSum(1,7),8);
        System.out.println("test1");
        Assert.assertEquals(getSum(2,8),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(1,5),6);
        System.out.println("test3");
        Assert.assertEquals(getSum(2,7),9);
        System.out.println("test4");
    }
    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getSum(1,7),8);
        System.out.println("test1");
        softAssert.assertEquals(getSum(2,8),10);
        System.out.println("test2");
        softAssert.assertEquals(getSum(7,9),16);
        System.out.println("test3");
        softAssert.assertEquals(getSum(2,7),9);
        System.out.println("test4");
    }
}
