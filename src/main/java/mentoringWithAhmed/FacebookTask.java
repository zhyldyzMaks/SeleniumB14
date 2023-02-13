package mentoringWithAhmed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FacebookTask {

    @Test
    public void facebookCreatingAccount(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        WebElement createAccount=driver.findElement(By.linkText("Create new account"));
        createAccount.click();

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Jil");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Maks");


        WebElement email=driver.findElement(By.name("reg_email__"));
        email.sendKeys("+13124852239");


        WebElement password=driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("3121234567!");

        WebElement birthdayMonth=driver.findElement(By.name("birthday_month"));
        BrowserUtils.selectBy(birthdayMonth,"11","value");

        WebElement birthDay=driver.findElement(By.name("birthday_day"));
        BrowserUtils.selectBy(birthDay,"11","value");

        WebElement birthYear=driver.findElement(By.name("birthday_year"));
        BrowserUtils.selectBy(birthYear,"2000","value");

        WebElement gender =driver.findElement(By.xpath("//input[@value='-1']"));
        gender.click();

        WebElement pronoun=driver.findElement(By.name("preferred_pronoun"));
        //pronoun.click();
        BrowserUtils.selectBy(pronoun,"1","value");

        WebElement signin=driver.findElement(By.xpath("//div[@class='_1lch']//button[@type='submit']"));
        signin.click();

    }

    @Test
    public void demoqaTask(){
        /*
1-Navigate to the https://demoqa.com/browser-windows
2-Click New Tab and validate the message from new window which is "This is a sample page"
3-Go to the main page and Click Frames from the list(on the left)
4-Validate This is a sample page from the box
5-Click Nested Frame from the list(on the left)
6-Validate Child iframe from the box
//5-Click Nested Frame from the list(on the left)
//6-Validate Child iframe from the box

    PURPOSE:1-Practicing the GetWindowHandles
            2-Practicing Frames and Nested Frames
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newTab=driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTab.click();

        BrowserUtils.switchById(driver);
        WebElement message=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(message),"This is a sample page");

        BrowserUtils.switchByTitle(driver,"ToolsQA");
        WebElement frames=driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
        BrowserUtils.scrollIntoView(driver,frames);
        frames.click();
        driver.switchTo().frame("frame2");

        WebElement header=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        Assert.assertEquals(BrowserUtils.getText(header),"This is a sample page");
        driver.switchTo().defaultContent();

        WebElement nestedFrame=driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
        BrowserUtils.scrollIntoView(driver,nestedFrame);
        nestedFrame.click();
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        WebElement childFrame=driver.findElement(By.xpath("//body//p[.='Child Iframe']"));
        Assert.assertEquals(BrowserUtils.getText(childFrame),"Child Iframe");
    }

}
