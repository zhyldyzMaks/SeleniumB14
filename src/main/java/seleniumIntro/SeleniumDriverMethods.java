package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());//google
        System.out.println(driver.getCurrentUrl());//google
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());//youtube
        System.out.println(driver.getCurrentUrl());//youtube
        driver.navigate().refresh();
        Thread.sleep(3000);//wait between methods
        driver.navigate().back();//google
        Thread.sleep(3000);
        driver.navigate().forward();//youtube
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());//gives us HTML structure of a page in a text format
        driver.close();

    }
}
