package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro {
    public static void main(String[] args) {
        //LOCATOR : ID
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/zhyldyzmaksatbek/Downloads/Techtorialhtml.html");

        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        String actualHeader =header.getText().trim();//comes from system
        String expectedHeader="Techtorial Academy";//comes from me, requirement

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Your header is passed");
        }else {
            System.out.println("Your header is failed");
        }

        WebElement parag =driver.findElement(By.id("details2"));
        System.out.println(parag.getText().trim());

        //LOCATOR : NAME

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Jyldyz");

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Maksatbek");

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("16546153");


        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("kjfkj@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("Creek Ct");

        WebElement city= driver.findElement(By.name("city"));
        city.sendKeys("MP");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postCode= driver.findElement(By.name("postalCode"));
        postCode.sendKeys("60056");

        //LOCATOR : CLASSNAME ClassName

        WebElement checkboxes=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxes.getText());

        WebElement javaBox =driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()){
            javaBox.click();
        }
        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        System.out.println(seleniumBox.isDisplayed());//true
        System.out.println(seleniumBox.isSelected());//true
        seleniumBox.click();
        System.out.println(seleniumBox.isSelected());//false


        //LOCATOR : TAGNAME TagName

        WebElement javaVersion = driver.findElement(By.tagName("u"));
        String actualVersion=javaVersion.getText().trim();
        String expectedVersion="Use Java Version";
        if (actualVersion.equals(expectedVersion)){
            System.out.println("The version is correct");
        }else{
            System.out.println("The version is incorrect");
        }














    }

}
