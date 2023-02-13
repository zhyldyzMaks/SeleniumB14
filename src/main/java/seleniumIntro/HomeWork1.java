package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yahoo.com/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Yahoo title is passed");
        }else{
            System.out.println("Yahoo title is failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.yahoo.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Yahoo url is passed");
        }else{
            System.out.println("Yahoo url is failed");
        }
        driver.close();

    }
}
