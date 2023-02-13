package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YTPractice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdrive.chore.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        WebElement search=driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Mirbek Atabekov");

        WebElement searchButton=driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();
        Thread.sleep(4000);

        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song : allSongs){
            if (song.getAttribute("title").equals("Mirbek Atabekov - Balama /Mood video / Curltai 2022")){
                song.click();
            }
        }

    }
}
