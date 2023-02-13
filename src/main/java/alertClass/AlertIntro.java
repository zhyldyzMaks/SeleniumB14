package alertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");

        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();

    }

    @Test
    public void dismiss(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();

        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");

    }

    @Test
    public void sendKeysAlert(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
        jsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("I love Selenium");
        alert.accept();

        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: I love Selenium");

    }
}
