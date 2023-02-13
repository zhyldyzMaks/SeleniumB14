package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YahooRealInterviewQuestion {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.yahoo.com/");

        WebElement news=driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();

        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3"));
        int counter=0;
        for (WebElement header : allHeaders){
            System.out.println(header.getText().trim());
            counter++;
        }
        System.out.println(counter);

    }
}
