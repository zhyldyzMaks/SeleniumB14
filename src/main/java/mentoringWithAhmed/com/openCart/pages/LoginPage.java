package mentoringWithAhmed.com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input-username")
    WebElement userName;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    public void setLoginButton(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
