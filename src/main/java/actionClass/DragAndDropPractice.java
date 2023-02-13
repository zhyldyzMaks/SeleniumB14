package actionClass;

import com.beust.ah.A;
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

public class DragAndDropPractice {
    @Test
    public void dragAndDrop(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(droppable);
        String expectedMessage ="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();

        droppable = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
        String actualMessageAfterDrop = BrowserUtils.getText(droppable);
        String expectedMessageAfterDrop ="Dropped!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);


       String actualcolor= droppable.getCssValue("background-color");
       String expectedColor="rgba(70, 130, 180, 1)";
       Assert.assertEquals(actualcolor,expectedColor);


    }
    @Test
    public void acceptValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement accept=driver.findElement(By.id("droppableExample-tab-accept"));
        accept.click();

        WebElement notAcceptable=driver.findElement(By.id("notAcceptable"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

        Assert.assertEquals(BrowserUtils.getText(droppable),"Drop here");

        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(droppable).release().perform();


        Assert.assertEquals(BrowserUtils.getText(droppable),"Drop here");
    }

}
