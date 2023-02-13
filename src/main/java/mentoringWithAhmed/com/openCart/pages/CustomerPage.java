package mentoringWithAhmed.com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@id='menu-customer']")
    WebElement customers1;
    @FindBy(xpath = "//ul[@id='collapse-5']//a[.='Customers']")
    WebElement customers2;

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addButton;
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @FindBy(id = "input-email")
    WebElement email;
    @FindBy(id = "input-telephone")
    WebElement telephone;
    @FindBy(id = "input-password")
    WebElement password2;
    @FindBy(id = "input-confirm")
    WebElement confirm;
    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton2;
    @FindBy(id = "alert")
    WebElement message;


    public void customerValidation(WebDriver driver,String firstName,String lastName,String email,String telephone,
                                   String password,String confirm,String expectedMessage){
        customers1.click();
        customers2.click();
        addButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        BrowserUtils.scrollIntoView(driver,password2);
        this.password2.sendKeys(password);
        this.confirm.sendKeys(confirm);
        saveButton2.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);

    }

}
