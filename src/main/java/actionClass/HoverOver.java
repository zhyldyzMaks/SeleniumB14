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
import java.util.*;

public class HoverOver {
    @Test
    public void hoverOver() throws InterruptedException {
        //MOVE TO ELEMENT
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allNames=driver.findElements(By.tagName("h5"));
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);
        for (int i = 0;i<allImages.size();i++){
            Thread.sleep(3000);
            actions.moveToElement(allImages.get(i)).perform();
            System.out.println(BrowserUtils.getText(allNames.get(i)));
            actualNames.add(allNames.get(i).getText().trim());
        }
        Assert.assertEquals(actualNames,expectedNames);
    }

    @Test
    public void HoverOverPractice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        List<WebElement> allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Actions actions=new Actions(driver);
        Map<String,String> menu = new HashMap<>();
        for (int i = 0; i<allNames.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            menu.put(allNames.get(i).getText().trim(), allPrices.get(i).getText());
        }
        System.out.println(menu);
    }

}
