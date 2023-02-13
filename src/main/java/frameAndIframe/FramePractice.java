package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    /*
TASK 1:
1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
2-Click Pavillion and Click Selenium-java under Selenium option
3-Validate the header " Selenium-Java Tutorial – Basic to Advance"



TASK 2:
1-Go back to the main page
2-click "category1"
3-validate the header "Category Archives: SeleniumTesting"

TASK 3:
1-Go back to the main page
2-click category 3 and validate
3-validate the header "Category Archives: SoftwareTesting"

 */
    @Test
    public void task1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");

        /*
        TASK 1:
1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
2-Click Pavillion and Click Selenium-java under Selenium option
3-Validate the header " Selenium-Java Tutorial – Basic to Advance"
         */

        WebElement pavillion=driver.findElement(By.linkText("Pavilion"));
        pavillion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");

        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();
        WebElement header=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Java Tutorial – Basic to Advance");

        /*
        TASK 2:
1-Go back to the main page
2-click "category1"
3-validate the header "Category Archives: SeleniumTesting"
         */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement header1=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header1), "Category Archives: SeleniumTesting");

/*
TASK 3:
1-Go back to the main page
2-click category 3 and validate
3-validate the header "Category Archives: SoftwareTesting"

 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        WebElement header3=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header3),"Category Archives: SoftwareTesting");
        driver.quit();

    }


}
