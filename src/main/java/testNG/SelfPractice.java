package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelfPractice {

    @Test
    public void codingBatValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://codingbat.com/java");

        List<WebElement> allBoxes=driver.findElements(By.xpath("//div[@class='summ']"));
        for (WebElement box : allBoxes){
            if (box.getText().trim().equals("String-2"));
            box.click();
        }

    }

    @Test
    public void selectValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://evisaforms.state.gov/Instructions/SchedulingSystem.asp");

        WebElement countryBox=driver.findElement(By.name("CountryCodeShow"));
        Select country = new Select(countryBox);
        List<WebElement> countries=country.getOptions();
        System.out.println(countries.size());
        for (WebElement cntry: countries){
            System.out.println(cntry.getText());
        }
        WebElement firstOption=country.getFirstSelectedOption();
        Assert.assertEquals(firstOption.getText().trim(),"Select a Country");

        country.selectByValue("KGZ       ");
        country.selectByVisibleText("FIJI ");
        country.selectByIndex(10);

    }
}
