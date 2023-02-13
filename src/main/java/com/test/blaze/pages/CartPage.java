package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cartButton;

    @FindBy(xpath = "//tbody//tr[@class='success']//td")
    List<WebElement> allInfo;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrder;

/*
1-Click Add to cart button
2-Validate the message "Product added" and click OK button
3-Click Cart button at the top of page and validate the name "MacBook Pro" and "1100"
4-Click PlaceOrder Button
5-Fill all the necessary Information and click Purchase
6-Validate the Message "Thank you for your purchase!"
7-Click OK button
8-Validate you are on the "https://www.demoblaze.com/index.html"
9-driver.quit
10-Then Proud of yourself
 */

    public void validateCart(WebDriver driver,String alertM,String macBook,String price) throws InterruptedException {
        addToCart.click();
        Thread.sleep(3000);
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),alertM);
        alert.accept();
        cartButton.click();
        List<String> expectedInfo= Arrays.asList("",macBook,price,"");
        for (int i=1;i<allInfo.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expectedInfo.get(i));
        }
        placeOrder.click();



    }

}
