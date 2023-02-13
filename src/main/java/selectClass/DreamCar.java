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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

 /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX-350
}
     */
    @Test
    public void lexusValidation(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        WebElement newOption =driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newOption,"New","text");


        WebElement carType =driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(carType,"Lexus","text");

        WebElement carModel =driver.findElement(By.id("models"));
        BrowserUtils.selectBy(carModel,"lexus-rx_350","value");

        WebElement firstSelectedPrice =driver.findElement(By.id("make-model-max-price"));
        Select firstPrice = new Select(firstSelectedPrice);
        WebElement firstOption=firstPrice.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(firstOption),"No max price");



        WebElement distance =driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40","value");

        WebElement zipcode =driver.findElement(By.id("make-model-zip"));
        zipcode.clear();
        zipcode.sendKeys("60056");


        WebElement searchButton =driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();

        WebElement header =driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Lexus RX 350 for sale");


        WebElement lowestPrice =driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(lowestPrice,"Lowest price","text");

        List<WebElement> lowestLexuses =driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement lexus:lowestLexuses){
            System.out.println(BrowserUtils.getText(lexus));
            Assert.assertTrue(lexus.getText().contains("Lexus RX 350"));
        }

        List<String> actualList =new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        List<Integer> prices=new ArrayList<>();
        List<Integer> prices1=new ArrayList<>();
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        for (WebElement price : allPrices){
            actualList.add(price.getText().replace("$","").replace(",",""));
            expectedList.add(price.getText().replace("$","").replace(",",""));
        }

        for (int i = 0; i<actualList.size();i++){
           prices.add(Integer.parseInt(actualList.get(i)));
           prices1.add(Integer.parseInt(expectedList.get(i)));
            Collections.sort(expectedList);
            Collections.reverse(expectedList);
            System.out.println(actualList);
            System.out.println(expectedList);
            Assert.assertEquals(actualList,expectedList);

        }
        System.out.println(prices);

    }
    /*
    1-Choose any car you want to buy
    2-Whenever you choose the lowest price from sorting
    3-Validate the prices are from lowest to highest(remember 2 list)
    4-After that choose the highest price from sorting
    5-Validate the prices are from highest to lowest (2 lists)
    NOTE:I would think about replacing $ and , with nothing or , with . (if you want to use double)
    NOTE:I would use lists for comparison
     */

    @Test
    public void ascendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        WebElement newOption =driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newOption,"New","text");


        WebElement carType =driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(carType,"lexus","value");

        WebElement carModel =driver.findElement(By.id("models"));
        BrowserUtils.selectBy(carModel,"lexus-gx_460","value");

        WebElement firstSelectedPrice =driver.findElement(By.id("make-model-max-price"));
        Select firstPrice = new Select(firstSelectedPrice);
        WebElement firstOption=firstPrice.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(firstOption),"No max price");



        WebElement distance =driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40","value");

        WebElement zipcode =driver.findElement(By.id("make-model-zip"));
        zipcode.clear();
        zipcode.sendKeys("60056");


        WebElement searchButton =driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();

        WebElement lowestPrice =driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(lowestPrice,"Lowest price","text");
        Thread.sleep(1000);


        List<String> actualList =new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        List<Integer> prices=new ArrayList<>();
        List<Integer> prices1=new ArrayList<>();
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        for (WebElement price : allPrices){
            actualList.add(price.getText().replace("$","").replace(",",""));
            expectedList.add(price.getText().replace("$","").replace(",",""));
        }

        for (int i = 0; i<actualList.size();i++){
            prices.add(Integer.parseInt(actualList.get(i)));
            prices1.add(Integer.parseInt(expectedList.get(i)));

        }

        Collections.sort(prices1);
        Assert.assertEquals(prices,prices1);



        WebElement highestPrice =driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(highestPrice,"Highest price","text");
        Thread.sleep(1000);


        List<String> actualList1 =new ArrayList<>();
        List<String> expectedList1 = new ArrayList<>();
        List<Integer> highestPrices=new ArrayList<>();
        List<Integer> highestPrices1=new ArrayList<>();
        List<WebElement> allHighestPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        for (WebElement price : allHighestPrices){
            actualList1.add(price.getText().replace("$","").replace(",",""));
            expectedList1.add(price.getText().replace("$","").replace(",",""));
        }

        for (int i = 0; i<actualList.size();i++){
            highestPrices.add(Integer.parseInt(actualList1.get(i)));
            highestPrices1.add(Integer.parseInt(expectedList1.get(i)));

        }

        Assert.assertEquals(highestPrices,highestPrices1);

    }

}
