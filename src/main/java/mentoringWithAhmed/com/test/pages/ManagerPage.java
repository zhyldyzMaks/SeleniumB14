package mentoringWithAhmed.com.test.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ManagerPage {

     /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE and click OK
10-Click Customers Button
11-Validate your firstname,lastName,PostCode and Account Number
12-driver.quit
13-Proud of yourself
 */

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[.='Add Customer']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;


    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(xpath = "//tbody//tr[6]//td")
    List<WebElement> allInfo;



    public void customerValidation(String name, String lName, String pCode,WebDriver driver){

        addCustomer.click();
        firstName.sendKeys(name);
        lastName.sendKeys(lName);
        postCode.sendKeys(pCode);
        addCustomerButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Customer added successfully with customer id :6");
        alert.accept();
        openAccount.click();
        BrowserUtils.selectBy(customerName,"6","value");
        BrowserUtils.selectBy(currency,"Dollar","value");
        processButton.click();
        alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Account created successfully with account Number :1016");
        alert.accept();
        customersButton.click();
        List<String> expectedInfo= Arrays.asList(name,lName,pCode);
        for (int i = 0; i<allInfo.size()-2;i++){
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expectedInfo.get(i));
        }







    }

}
