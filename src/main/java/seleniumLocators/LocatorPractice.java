package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {

        System.setProperty("webdrive.chome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement internet=driver.findElement(By.linkText("Horizontal Slider"));
        internet.click();
        WebElement horizontalHeader=driver.findElement(By.tagName("h3"));
        System.out.println(horizontalHeader.getText().trim());

        WebElement paragraph= driver.findElement(By.className("subheader"));
        System.out.println(paragraph.getText().trim());

        WebElement selenium=driver.findElement(By.linkText("Elemental Selenium"));
        selenium.click();

        driver.quit();


    }
}
