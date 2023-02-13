package mentoringWithAhmed.com.openCart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement xButton;
    @FindBy(xpath = "//div[@class='row']//h2")
    List<WebElement> allNumbers ;


    public void numbersValidation(WebDriver driver,String num1,String num2,String num3,String num4){

       xButton.click();
       List<String> expectedNumbers= Arrays.asList(num1,num2,num3,num4);
       for (int i =0; i<expectedNumbers.size();i++){
          Assert.assertEquals(allNumbers.get(i).getText(),expectedNumbers.get(i));
       }

    }


}
