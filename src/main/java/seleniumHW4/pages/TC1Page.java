package seleniumHW4.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class TC1Page {

    public TC1Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "authUser")
    WebElement userName;
    @FindBy(id = "clearPass")
    WebElement password;
    @FindBy(xpath = "//select[@class='form-control']")
    WebElement language;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Finder')]")
    WebElement finderButton;
    @FindBy(xpath = "//input[contains(@type,'search')]")
    WebElement finderSearchBox;
    @FindBy(xpath = "//tr[@id='pid_1']//td")
    List<WebElement> patientAllInfo;
    @FindBy(xpath = "//tr[@id='pid_1']//td[5]")
    WebElement externalID;
    @FindBy(xpath = "//tr[@id='pid_1']//td[1]")
    WebElement belfordPhil;
    @FindBy(xpath = "//a[contains(text(),'Demographics')]")
    WebElement demographics;
    @FindBy(xpath = "//span[@data-bind='text: pubpid']")
    WebElement demopraphOne;
    @FindBy(xpath = "//span[contains(text(),' DOB: 09/02/1972 Age: 50')]")
    WebElement dob;
     /*
    Navigate to "https://demo.openemr.io/openemr"
Enter username "admin"
Enter password "pass"
Search the "Belford, Phil" from the search box under the
patient finder ( finder on the top )
Validate Name ( is name Belford Phil)
Validate Phone Number (333 - 444 - 2222)
Validate SSN number (333222333)
Validate external ID are matching in Home page and Patient
Dashboard (click to patient and click to demographics to get
external ID)
Validate DOB is displayed
Validate age is correct according to the DOB of patient
(how old is Phil)
     */

    public void loginPage(WebDriver driver, String name, String pssword) {
        userName.sendKeys(name);
        password.sendKeys(pssword);
        BrowserUtils.selectBy(language,"1","value");
        loginButton.click();
        finderButton.click();
        driver.switchTo().frame("fin");
        finderSearchBox.sendKeys("Belford");
    }

    public void patientValidation(WebDriver driver, String patientName, String phoneNumber, String ssn, String dob) throws InterruptedException {

        List<String> expectedInfo = Arrays.asList(patientName, phoneNumber, ssn, dob, "");
        for (int i = 0; i < patientAllInfo.size() - 1; i++) {
            Thread.sleep(2000);
            Assert.assertEquals(BrowserUtils.getText(patientAllInfo.get(i)), expectedInfo.get(i));
        }
        String text = BrowserUtils.getText(externalID);
        belfordPhil.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");
        demographics.click();
        driver.switchTo().defaultContent();
        String text2 = BrowserUtils.getText(demopraphOne);
        Assert.assertTrue(this.dob.isDisplayed());
        Assert.assertEquals(text, text2);

    }

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

    public void editValidation(String message) {
        belfordPhil.click();
        messagesEditButton.click();
        addButton.click();
        BrowserUtils.selectBy(type1, "Lab Results", "value");
        BrowserUtils.selectBy(assignedTo, "zhportal", "value");
        messageBox.sendKeys(message);
        saveButton.click();


    }
}