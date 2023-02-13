package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeCSSLocator {

    public static void main(String[] args) {
        System.setProperty("webdrive.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");

        //2-Fill all the boxes
        WebElement firstName=driver.findElement(By.cssSelector("#input-firstname"));
        firstName.sendKeys("Jyldyz");

        WebElement lastName=driver.findElement(By.cssSelector("#input-lastname"));
        lastName.sendKeys("Maksatbek");
        WebElement email=driver.findElement(By.cssSelector("#input-email"));
        email.sendKeys("jyz12!!@gmail.com");
        WebElement phone=driver.findElement(By.cssSelector("#input-telephone"));
        phone.sendKeys("12345657");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("Jyldyz123!");
        WebElement passwordConfirm=driver.findElement(By.cssSelector("#input-confirm"));
        passwordConfirm.sendKeys("Jyldyz123!");

        //3-Click privacy button
        WebElement privacyButton=driver.findElement(By.tagName("b"));
        privacyButton.click();

        WebElement privacyPolicy=driver.findElement(By.cssSelector(".modal-title"));
        String actualText =privacyPolicy.getText().trim();
        String expectedText="Privacy Policy";
        if (actualText.equals(expectedText)){
            System.out.println("Text is correct");
        }else{
            System.out.println("Text is wrong");
        }

        //5-CLick privacy button if it is not selected
        WebElement closeButton=driver.findElement(By.xpath("//button[@class='close']"));
        closeButton.click();

        //4-Click continue button
        WebElement checkBox=driver.findElement(By.xpath("//input[@name='agree']"));
        if (!checkBox.isSelected()){
            checkBox.click();
        }

        WebElement continueButton=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        continueButton.click();

        //5-Print out the text and close the tab
        WebElement text=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader=text.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Your account is created");
        }else{
            System.out.println("Sorry");
        }
        driver.quit();

        //5-Validate Account is created header

//NOTE:To be able to see account is created for you last run make sure you have a different email
//just add ahmet1,ahmet2 like that everytime for validation.




    }
}
