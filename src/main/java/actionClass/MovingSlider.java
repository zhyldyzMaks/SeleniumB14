package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MovingSlider {


    @Test
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range=driver.findElement(By.id("range"));
        String rangeNumber="4.5";
        //Actions actions=new Actions(driver);
        while(!BrowserUtils.getText(range).equals(rangeNumber)){
            slider.sendKeys(Keys.ARROW_RIGHT); //sendKeys from WebElement class
            //actions.sendKeys(slider,Keys.ARROW_RIGHT).perform();
        }
        Assert.assertEquals(BrowserUtils.getText(range),rangeNumber);
    }
}