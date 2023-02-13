package waittimes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {
    /*
    is all about waiting for certain elements for a specific time to be loaded
    NOTE: We store this under DriverHelper class.
     */
    @Test
    public void implicitWait(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
