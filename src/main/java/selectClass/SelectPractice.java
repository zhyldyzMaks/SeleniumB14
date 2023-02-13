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

public class SelectPractice {

    /*
    Navigate to the html techtorial website
    Get all the options and print them out
    Validate (Assert) the default value of box is "UNITED STATES"
     */

    @Test
    public void selectValidation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/zhyldyzmaksatbek/Downloads/Techtorialhtml.html");

        WebElement countryBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select countries=new Select(countryBox);
        List<WebElement> allCountries  = countries.getOptions();
        System.out.println(allCountries.size());
        for (WebElement country : allCountries){
            System.out.println(country.getText().trim());

        }

        WebElement firstSelected=countries.getFirstSelectedOption();
        Assert.assertEquals(firstSelected.getText().trim(),"UNITED STATES");

        /*
        Choose your country any method you want
         */
        countries.selectByValue("111");


    }

    @Test
    public void validateOrderMessage(){
        /*
        /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulca"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
9-Print out all the options from Airline
10-Click first class option.
11-Choose the Unified option from airline list
12-Click Continue
13-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Avaialble.
 NOTE2:You can use any select method value,visibleText

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengers=new Select(passengerBox);
        passengers.selectByValue("4");

        WebElement departBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select cities=new Select(departBox);
        WebElement acapulco=cities.getFirstSelectedOption();
        Assert.assertEquals(acapulco.getText().trim(), "Acapulco");
        cities.selectByValue("Paris");

        WebElement monthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select months=new Select(monthBox);
        months.selectByVisibleText("August");

        WebElement dayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select days=new Select(dayBox);
        days.selectByValue("15");

        WebElement toPortBox=driver.findElement(By.xpath(" //select[@name='toPort']"));
        Select toCities=new Select(toPortBox);
        toCities.selectByVisibleText("San Francisco");

        WebElement returnMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select month=new Select(returnMonth);
        month.selectByVisibleText("December");

        WebElement returnDay=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select day=new Select(returnDay);
        day.selectByValue("15");

        WebElement airlines=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlines);
        List<WebElement> allAirlineOption=airline.getOptions();
        for (WebElement airln : allAirlineOption){
            System.out.println(airln.getText().trim());
        }
        airline.selectByVisibleText("Unified Airlines");

        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();

        WebElement header=driver.findElement(By.xpath("//font[@size='4']"));
        String actual = header.getText().trim();
        String expected ="After flight finder - No Seats Available";
        Assert.assertEquals(actual,expected);
        //Assert.assertEquals(header.getText().trim(), "After flight finder - No Seats Available");

    }
    @Test
    public void secondWaySelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerBox,"4","text");

        WebElement departBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(departBox,"Paris", "value");
        Select cities=new Select(departBox);
        WebElement acapulco=cities.getFirstSelectedOption();
        Assert.assertEquals(acapulco.getText().trim(), "Paris");

        WebElement monthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(monthBox,"August","text");

        WebElement dayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dayBox,"15","value");

        WebElement toPortBox=driver.findElement(By.xpath(" //select[@name='toPort']"));
        BrowserUtils.selectBy(toPortBox,"San Francisco","text");

        WebElement returnMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returnMonth,"December","text");

        WebElement returnDay=driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returnDay,"15","value");

        WebElement airlines=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlines);
        List<WebElement> allAirlineOption=airline.getOptions();
        for (WebElement airlne : allAirlineOption){
            System.out.println(BrowserUtils.getText(airlne));
        }
        airline.selectByVisibleText("Unified Airlines");

        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();

        WebElement header=driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(header.getText().trim(), "After flight finder - No Seats Available");

    }


}
