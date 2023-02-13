package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubePractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        1-Navigate to the website youtube
2-Search for justin bieber
3-Find the all song names and store in the list Justin Bieber - One Time (Official Music Video)
4-Use for and if conditions to find the song
5-Click the song
6-Enjoy your music
7-Ready to be level 2
         */
        System.setProperty("webdrive.chore.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        WebElement search=driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber");
        WebElement searchButton= driver.findElement(By.xpath("//button[@class='style-scope ytd-searchbox']"));
        searchButton.click();
        Thread.sleep(5000); //good to wait to upload all list of songs

        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song : allSongs){
            if(song.getAttribute("title").equals("Justin Bieber - One Time (Official Music Video)")){
                song.click();
            }
        }

    }
}
