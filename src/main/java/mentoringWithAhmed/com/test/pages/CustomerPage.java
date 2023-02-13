package mentoringWithAhmed.com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import seleniumLocators.XpathLocators;
import utils.BrowserUtils;

import javax.xml.xpath.XPath;
/*

     1-Click Customer Login
     2-Find your Name from the List
     3-Click Login
     4-Validate the "Welcome Your Name" from header
     5-Click Deposit and put 500
     6-Validate "Deposit Successful
     7-Click Withdrawl and put 300
     8-Validate "Transaction successful"
     9-Get the balance from the Customer Page(200)
     10-Click Transaction
     11-get the 500 and 300 from the table and substract them
     12-Validate balance from customer page amount(200) equals to transaction amount(500-300).
     12-Quit the driver
     */

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),' Welcome')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement putDepositBox;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement depositBox2;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessful;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withDrawl;

    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement putWithDrawlBox;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement withdrawl2Button;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement withdrawlSuccessful;

    @FindBy(xpath = "//div//strong[contains(text(),'200')]")
    WebElement balance200;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transaction;

    @FindBy(xpath = "//td[.='500']")
    WebElement fiveHundred;

    @FindBy(xpath = "//td[.='300']")
    WebElement threeHundred;

    public void customerValidation(String deposit,String wthdrawl) throws InterruptedException {

        BrowserUtils.selectBy(userSelect,"2","value");
        loginButton.click();
        Assert.assertEquals(welcomeMessage.getText().trim(),"Welcome Harry Potter !!");
        depositButton.click();
        putDepositBox.sendKeys(deposit);
        depositBox2.click();
        Assert.assertEquals(depositSuccessful.getText().trim(),"Deposit Successful");
        withDrawl.click();
        Thread.sleep(1000);
        putWithDrawlBox.sendKeys(wthdrawl);
        withdrawl2Button.click();
        Assert.assertEquals(withdrawlSuccessful.getText().trim(),"Transaction successful");
        Thread.sleep(1000);
        String balanceS=balance200.getText().trim();
        Integer balanceI=Integer.parseInt(balanceS);
        transaction.click();
        String fiveH = fiveHundred.getText().trim();
        Integer fvHndrd = Integer.parseInt(fiveH);
        String threeH = threeHundred.getText().trim();
        Integer thrHndrd = Integer.parseInt(threeH);
        Integer total= fvHndrd-thrHndrd;
        Assert.assertEquals(balanceI,total);


    }

}
