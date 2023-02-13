package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RealAutomationForXPath {
    public static void main(String[] args) {

         //THESE PARTS SHOULD BE DONE BY XPATH:


        System.setProperty("webdrive.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();

        //1-Navigate to the https://katalon-demo-cura.herokuapp.com/
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2-Click Make an Appointment
        WebElement appointment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appointment.click();

        //Login the username
        WebElement userName=driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        //and password provided
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        //-and Login successfully
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();

        //4-Choose the facility either HongKong or Seoul -->send keys
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        //5-Click apply for hospital admission box if it is displayed and validate it is selected
        WebElement applyBox=driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (applyBox.isDisplayed()&&!applyBox.isSelected()){
            applyBox.click();
        }
        System.out.println(applyBox.isSelected()); //true

        //6-Healthcare program 'Medicaid'
        WebElement medicaid=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        //7-Visit date should be provided -->send keys
        WebElement date=driver.findElement(By.xpath("//input[@class='form-control']"));
        date.sendKeys("02/12/2022");

        //8-Put your comment for this box -->send keys
        WebElement comment=driver.findElement(By.xpath("//textarea[@name='comment']"));
        comment.sendKeys("Hello");

        //9-Book your appointment
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        //THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
        //10-Validate the header is "Appointment confirmation" (if statement)
        WebElement appConfirmation=driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        System.out.println(appConfirmation.getText().trim());

        //11-Print out the headers and values(only values) on your console.
        WebElement facilityVal=driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facilityVal.getText().trim());
        WebElement header=driver.findElement(By.tagName("h2"));
        System.out.println(header.getText());

        //12)Click go to homepage and print out url
        WebElement homepage=driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        homepage.click();
        System.out.println(driver.getCurrentUrl());

        //13)Driver.quit or close.
        driver.quit();



    }
}
