package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("firstName")

    @Test
    public void test(String name){
        System.out.println(name);
    }

    @Parameters({"Cntry","Cty","ZipCd"}) //this order has to match with parameters order inside test2 scobs
    @Test
    public void test2(String country, String city, String zipcode){
        System.out.println(country);
        System.out.println(city);
        System.out.println(zipcode);
    }

}
