package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MacBookProTest extends TestBaseBlaze{

    @Test
    public void validateLaptop(){

        MainPageBlaze mainPage=new MainPageBlaze(driver);
        mainPage.clickLaptop();

        LaptopPageBlaze laptopPageBlaze=new LaptopPageBlaze(driver);
        laptopPageBlaze.validateAllLaptops(driver,"MacBook Pro");

        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.validationProductInfo("MacBook Pro","$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar," +
                        " a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
    }




    @Parameters({"laptopBrand","expectedCartMessage","price","name","country","city",
                 "creditCard","month","year","expectedOrderMessage","expectedUrl"})
     //These parameters order must match the order of Test Parameters(below). Name is not matter.
    @Test
    public void orderValidation(String laptopBrand, String expectedCartMessage,String price,
                               String name,String country,String city,String creditCard, String month,
                               String year,String expectedOrderMessage,String expectedUrl) throws InterruptedException {
        MainPageBlaze mainPage=new MainPageBlaze(driver);
        mainPage.clickLaptop();

        LaptopPageBlaze laptopPageBlaze=new LaptopPageBlaze(driver);
        laptopPageBlaze.validateAllLaptops(driver,laptopBrand);//MacBook Pro

        CartPage cartPage=new CartPage(driver);
        cartPage.validateCart(driver,expectedCartMessage,laptopBrand,price);//Product added


        OrderPage orderPage=new OrderPage(driver);
        orderPage.createOrder(name,country,city,creditCard,month,year,
                expectedOrderMessage,driver,expectedUrl); //Thank you for your purchase!
    }


    @Test(dataProvider = "customerData",dataProviderClass = DataProviderCustomerData.class)
    public void validateOrderDataProvider(String laptopBrand, String expectedCartMessage,String price,
                               String name,String country,String city,String creditCard, String month,
                               String year,String expectedOrderMessage,String expectedUrl) throws InterruptedException {
        MainPageBlaze mainPage=new MainPageBlaze(driver);
        mainPage.clickLaptop();

        LaptopPageBlaze laptopPageBlaze=new LaptopPageBlaze(driver);
        laptopPageBlaze.validateAllLaptops(driver,laptopBrand);//MacBook Pro

        CartPage cartPage=new CartPage(driver);
        cartPage.validateCart(driver,expectedCartMessage,laptopBrand,price);//Product added

        OrderPage orderPage=new OrderPage(driver);
        orderPage.createOrder(name,country,city,creditCard,month,year,
                expectedOrderMessage,driver,expectedUrl); //Thank you for your purchase!
    }


}
