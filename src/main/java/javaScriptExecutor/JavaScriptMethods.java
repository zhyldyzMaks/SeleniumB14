package javaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {
    /*
    NOTE: JavaScript is really efficient once your normal selenium methods are not working as expected
    NOTE: JavaScript is a different language so it is not recommended to use Java and JavaScript all the time.
    That's why JavaScript methods should be your last option to use.
     For Example: You are trying to click the element somehow WebElement.click is not working
                  then you should try Actions.click it is also not working
                  THEN USE JAVASCRIPT CLICK METHOD.
     */

    @Test
    public void getTitle() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println("Get the title with driver " + driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get the title with JS " + title);

    }

    @Test
    public void clickJS() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",onlineCourse);
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);


    }
    @Test
    public void scrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement copyRight=driver.findElement(By.xpath("//p[contains(text(),'© Copyrights 2022')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        js.executeScript("arguments[0].scrollIntoView(true)",onlineCourse);
    }

    @Test
    public void task1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement browseCourse=driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",browseCourse);
        js.executeScript("arguments[0].click()",browseCourse);
        String title = js.executeScript("return document.title").toString();
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(title,expectedTitle);

        WebElement information=driver.findElement(By.xpath("//h2[contains(text(),'information')]"));
        js.executeScript("arguments[0].scrollIntoView(true)",information);

        WebElement studentLoginButton=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[@data-toggle='modal']"));
        js.executeScript("arguments[0].scrollIntoView(true)",studentLoginButton);
        js.executeScript("arguments[0].click()",studentLoginButton);

    }
    @Test
    public void shortCutTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement browseCourse=driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        BrowserUtils.scrollIntoView(driver,browseCourse);
        BrowserUtils.clickWithJS(driver,browseCourse);
        String title = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(title,expectedTitle);

        WebElement information=driver.findElement(By.xpath("//h2[contains(text(),'information')]"));
        BrowserUtils.scrollIntoView(driver,information);

        WebElement studentLoginButton=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[@data-toggle='modal']"));
        BrowserUtils.scrollIntoView(driver,studentLoginButton);
        BrowserUtils.clickWithJS(driver,studentLoginButton);
    }
}