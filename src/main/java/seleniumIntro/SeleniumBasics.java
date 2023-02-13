package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //We are setting up our automation
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //window users should put exe at the end
        WebDriver driver = new ChromeDriver();
        //this is the example of polymorphism. We are creating chromedriver from WebDriver
        driver.manage().window().maximize();//thi maximize your screen
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();// comes from user
        String expectedTitle = "Home Page - Techtorial";//comes from us

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        driver.close();

    }
}
