package javaScriptExecutor;

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
         /*
        TASK1: PLEASE USE ALL JS METHODS WITH BROWSER UTILS
1-Navigate to the website https://www.techtorialacademy.com/
2-Click Browse Course
3-Click SDET Course Get Started
4-Validate the Title
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");


        WebElement browseCourse=driver.findElement(By.linkText("Browse Course"));
        BrowserUtils.clickWithJS(driver,browseCourse);

        WebElement sdetCourseGetStarted=driver.findElement(By.xpath("//div/h4[.='SDET Course']//..//a[@class='btn btn-default btnStyle3']"));
        BrowserUtils.scrollIntoView(driver,sdetCourseGetStarted);
        BrowserUtils.clickWithJS(driver,sdetCourseGetStarted);

        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply To Techtorial - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void videoPlayer(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.thespruceeats.com/");

        WebElement video =driver.findElement(By.xpath("//div[@id='homepage-video-player__video-player_1-0']"));
        BrowserUtils.scrollIntoView(driver,video);

        WebElement playButton=driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-display jw-button-color jw-reset']"));
        playButton.click();


    }
}
