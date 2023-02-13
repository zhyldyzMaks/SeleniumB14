package mentoringWithAhmed.com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
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

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    public void clickManager(){
        bankManagerLogin.click();
    }
    public void clickCustomer(){
        customerLogin.click();
    }
}
