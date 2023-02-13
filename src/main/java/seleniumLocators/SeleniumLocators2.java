package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumLocators2 {
    public static void main(String[] args) {

        System.setProperty("webdrive.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/zhyldyzmaksatbek/Downloads/Techtorialhtml.html");

        //LOCATOR : LINKTEXT LinkText
        WebElement java=driver.findElement(By.linkText("Java"));
        java.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText().trim());
        driver.navigate().back();

        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader= driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim());
        driver.navigate().back();

        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader= driver.findElement(By.tagName("h1"));
        System.out.println(cucumberHeader.getText().trim());
        driver.navigate().back();

        WebElement testNg=driver.findElement(By.linkText("testNG"));
        testNg.click();
        WebElement testNgHeader= driver.findElement(By.tagName("h2"));
        System.out.println(testNgHeader.getText().trim());
        driver.navigate().back();
        //driver.close();


        //LOCATOR : PARTIALLINKTEXT PartialLinkText

        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());








    }
}
