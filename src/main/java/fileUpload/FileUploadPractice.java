package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/zhyldyzmaksatbek/Desktop/usa.png");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement message=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(BrowserUtils.getText(message),"File Uploaded!");
        WebElement attachment=driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(attachment),"usa.png");

    }
    @Test
    public void task(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.className("upload_txt"));
        chooseFile.sendKeys("/Users/zhyldyzmaksatbek/Desktop/usa.png");
        WebElement checkBox=driver.findElement(By.id("terms"));
        checkBox.click();
        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        submitButton.click();
        WebElement message=driver.findElement(By.xpath("//div[@class='formbuttons']//h3[@id='res']"));
        Assert.assertEquals(BrowserUtils.getText(message),"1 file\n" +
                "has been successfully uploaded.");
    }

}
