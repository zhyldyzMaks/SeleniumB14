package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Task1 {
    @Test
    public void task1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement multiTabButton=driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollIntoView(driver,multiTabButton);
        multiTabButton.click();

        BrowserUtils.switchByTitle(driver, "Basic Controls - H Y R Tutorials");
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Name");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Last Name");
        WebElement gender=driver.findElement(By.id("femalerb"));
        BrowserUtils.scrollIntoView(driver,gender);
        gender.click();
        WebElement language=driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("email@gmail.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("password123");
        WebElement scroll=driver.findElement(By.id("HTML6"));
        BrowserUtils.scrollIntoView(driver,scroll);
        WebElement registerButton=driver.findElement(By.id("registerbtn"));
        registerButton.click();
        WebElement success= driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));
        Assert.assertEquals(BrowserUtils.getText(success),"Registration is Successful");

        BrowserUtils.switchByTitle(driver, "Window Handles Practice");
        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "Window Handles Practice");

        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe=driver.findElement(By.id("promptBox"));
        BrowserUtils.scrollIntoView(driver,clickMe);
        clickMe.click();

        driver.quit();

    }
    @Test
    public void homework() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.hyrtutorials.com/p/window-handles-practice.html");

/*
TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open newWindow under Button1
  3-Get the title of the newWindow and validate"
  4-Get the header of the newWindow and validate "AlertsDemo"
  5-Click click me button
  6-Quit the windows
 */


        WebElement button1=driver.findElement(By.id("newWindowBtn"));
        BrowserUtils.scrollIntoView(driver,button1);
        button1.click();

        BrowserUtils.switchByTitle(driver,"Basic Controls");
        Assert.assertEquals(driver.getTitle().trim(),"Basic Controls - H Y R Tutorials");


        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        WebElement button2= driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollIntoView(driver,button2);
        button2.click();
        Thread.sleep(1000);

        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(header.getText().trim(), "AlertsDemo");

        WebElement clickMe=driver.findElement(By.id("alertBox"));
        clickMe.click();

    }
}
