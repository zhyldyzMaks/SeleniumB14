package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SelectBasics {

    //SELECT CLASS is all about drop down.
    // Drop down must have Select Tag name.

    @Test
    public void practiceSelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));
        dropDown.click();

        WebElement dropDownBox=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDwn=new Select(dropDownBox);
        List<WebElement> allOptions  = dropDwn.getOptions();
        for (WebElement option : allOptions){
            System.out.println(option.getText().trim());
        }

        WebElement firstSelected=dropDwn.getFirstSelectedOption();
        Assert.assertEquals(firstSelected.getText().trim(),"Please select an option");

        dropDwn.selectByVisibleText("Option 2");//it chooses the option by visible text
        dropDwn.selectByIndex(1); //it chooses the option by index
        dropDwn.selectByValue("2"); //it chooses the option by value

    }
    @Test
    public void selectMultiMethods(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/zhyldyzmaksatbek/Downloads/Techtorialhtml.html");

        WebElement countries=driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(countries,"Two","text");
        BrowserUtils.selectBy(countries,"3","value");
        BrowserUtils.selectBy(countries,"3","index");

        Select country=new Select(countries);
        country.deselectByValue("3");
        country.deselectAll();

    }
}
