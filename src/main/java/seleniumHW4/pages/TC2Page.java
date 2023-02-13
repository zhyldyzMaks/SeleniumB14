package seleniumHW4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class TC2Page {
    public TC2Page(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[@id='pid_1']//td[1]")
    WebElement belfordPhil;
    @FindBy(xpath = "//a[contains(text(),'Messages')]//..//span")
    WebElement messagesEditButton;
    @FindBy(xpath = "//a[.='Add']")
    WebElement addButton;
    @FindBy(id = "form_note_type")
    WebElement type1;
    @FindBy(id = "assigned_to")
    WebElement assignedTo;
    @FindBy(xpath = "//div[@class='form-group mt-3']//textarea[@id='note']")
    WebElement messageBox;
    @FindBy(id = "newnote")
    WebElement saveButton;

    /*
    Navigate to "https://demo.openemr.io/openemr"
Enter username "admin"
Enter password "pass"
Search the "Phil Belford" from the search box under the
patient finder
Click the edit button for "Messages"
Click add button
Select "Lab Result" for Type
Assign it to Jarvis, Fred
Type "This is for testing" to the message box
Save Patient Message
     */
    public void editValidation(WebDriver driver,String message){
        belfordPhil.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");
        messagesEditButton.click();
        addButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("modalframe");
        BrowserUtils.selectBy(type1,"Lab Results","value");
        BrowserUtils.selectBy(assignedTo,"zhportal","value");
        messageBox.sendKeys(message);
        saveButton.click();
    }
}
