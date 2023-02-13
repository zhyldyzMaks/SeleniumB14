package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void nestedFrame(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/frames");

        WebElement nestedFrame=driver.findElement(By.linkText("Nested Frames"));
        nestedFrame.click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");//gives NoSuchFrameException
        WebElement text=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(text));

        driver.switchTo().parentFrame();//go back to the one top parent frame
        driver.switchTo().frame("frame-middle");
        WebElement text1=driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(BrowserUtils.getText(text1));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement text2=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(text2));

        driver.switchTo().defaultContent();//it directly goes to the main html parent page. doesn't matter how many parent between are there.
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        WebElement text3=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(text3));

        driver.quit();




    }
}
