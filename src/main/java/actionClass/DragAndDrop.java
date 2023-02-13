package actionClass;

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

public class DragAndDrop {

    @Test
    public void validateTheMessageAndColor() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        WebElement circle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(target);//....Or here.
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(circle, target).perform();

        target = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageAfterDrop = BrowserUtils.getText(target);
        String expectedMessageAfterDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDrop, expectedMessageAfterDrop);

        String orangeBackgroundColor = target.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(orangeBackgroundColor, expectedBackgroundColor);


    }

    @Test
    public void validateBlueBox() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        WebElement circle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@class='test1']"));

        String actualMessage = BrowserUtils.getText(target);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage, expectedMessage);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(circle, target).perform();

        target = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualAfterDragging = BrowserUtils.getText(target);
        String expectedAfterDragging = "You did great!";
        Assert.assertEquals(actualAfterDragging, expectedAfterDragging);

        String blueColorBox = target.getCssValue("background-color");
        String expectedColorBox = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(blueColorBox, expectedColorBox);

    }
    //Click and Hold Method
    @Test
    public void clickAndHoldMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200);//scrolling down the page

        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        WebElement circle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getText(target), "Drag the small circle here ...");


        actions.clickAndHold(circle).moveToElement(target).release().perform();

        target = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(BrowserUtils.getText(target),"You did great!");

    }


}