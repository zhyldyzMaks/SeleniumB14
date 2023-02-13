package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAllData {
    @DataProvider(name ="loginFunctionality")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Mehmet"},
                {"Mahmut","Ayse"},
                {"Zeynep","Ayse"},
                {"Osman","Fatma"},
                {"Abdu","Baran"}
        };
    }

}
