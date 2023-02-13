package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

    //ContextClick(right click)

    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        WebElement contextMenu=driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();

        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(box).perform();

    }
    @Test
    public void contextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickMe=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action=new Actions(driver);
        action.contextClick(rightClickMe).perform();

    }
    //DoubleClick
    @Test
    public void DoubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleButton=driver.findElement(By.xpath("//button"));
        Actions action =new Actions(driver);
        action.doubleClick(doubleButton).perform();

    }

}
