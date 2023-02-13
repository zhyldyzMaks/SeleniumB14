package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class DataProviderCustomerData {
    @DataProvider(name ="customerData")
    public Object[][] getData(){
        return new Object[][]{
                {"MacBook Pro","Product added","1100","Ahmet","USA",
                        "Chicago","123456789084","12","2026","Thank you for your purchase!",
                "https://www.demoblaze.com/index.html"},

                {"MacBook air","Product added","700","Mehmet","Turkey",
                        "Ist","123456789034","12","2026","Thank you for your purchase!",
                        "https://www.demoblaze.com/index.html"}

        };
    }
}
