package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> allLines=driver.findElements(By.tagName("li"));
        for (WebElement line : allLines){
           // System.out.println(line.getText().trim());

        }
        /*TASK 2:
        -->Print out the links length less than 12
        -->Print out how many links are there less than 12
        */
        int counter=0;
        for (WebElement line : allLines){

                if (line.getText().trim().length() < 12){
                    System.out.println(line.getText().trim());
                    counter++;
                }
            }
        System.out.println(counter);
    }
}
