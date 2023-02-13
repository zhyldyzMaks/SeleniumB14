package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test
    public void switchMultipleWindows(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

//        Set<String> allPages=driver.getWindowHandles();
//        for (String id : allPages){
//            driver.switchTo().window(id);
//            if (driver.getTitle().contains("About Us")){
//                break;
//            }
//        }

        BrowserUtils.switchByTitle(driver,"About Us");
        Assert.assertEquals(driver.getTitle().trim(),"About Us - Techtorial");
        BrowserUtils.switchByTitle(driver,"Home Page");
        Assert.assertEquals(driver.getTitle().trim(),"Home Page - Techtorial");
        BrowserUtils.switchByTitle(driver,"Programs");
        Assert.assertEquals(driver.getTitle().trim(),"Programs - Techtorial");
        driver.quit();//closes all tabs
        //driver.close() closes only the last page

    }
}
