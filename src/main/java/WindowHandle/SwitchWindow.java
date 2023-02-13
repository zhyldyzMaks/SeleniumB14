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
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        String mainPageId = driver.getWindowHandle();
        System.out.println(mainPageId);

        Set<String> allPagesId = driver.getWindowHandles();
        System.out.println(allPagesId);

        for (String id : allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Window");

    }
    @Test
    public void practice(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2=driver.findElement(By.xpath("//h3[.='Button2']"));
        BrowserUtils.scrollIntoView(driver,button2);

        WebElement openNewTab=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        openNewTab.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allTabs=driver.getWindowHandles();

        for (String tab : allTabs){
            if (!tab.equals(mainPageId)){
                driver.switchTo().window(tab);

            }

        }
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");

        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo");

        WebElement clickMe=driver.findElement(By.xpath(" //button[@id='alertBox']"));
        clickMe.click();

        driver.quit();




    }


}
