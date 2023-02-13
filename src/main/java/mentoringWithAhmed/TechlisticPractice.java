package mentoringWithAhmed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class TechlisticPractice {

    @Test
    public void techlisticValidation(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
/*
Enter first and last name (textbox).
Select gender (radio button).
Select years of experience (radio button).
Enter date.(02-04-2022, 2022/2/4, 2022-04-02)
Select Profession (Checkbox).
Select Automation tools you are familiar with (multiple checkboxes).
Select Continent (Select box).
Select multiple commands from a multi select box. (at least 2)
Click on Submit button.
Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links.
 */
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Hello");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("World");

        WebElement genderButton=driver.findElement(By.id("sex-1"));
        genderButton.click();

        WebElement experience=driver.findElement(By.id("exp-0"));
        experience.click();

        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("02-04-2022");

        WebElement profession=driver.findElement(By.id("profession-1"));
        profession.click();

        WebElement automationTools=driver.findElement(By.id("tool-0"));
        automationTools.click();

        WebElement continents=driver.findElement(By.id("continents"));
        BrowserUtils.selectBy(continents,"North America","text");

        WebElement seleniumCommands=driver.findElement(By.id("selenium_commands"));
        BrowserUtils.selectBy(seleniumCommands,"Browser Commands","text");
        BrowserUtils.selectBy(seleniumCommands,"Navigation Commands","text");

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();

    }
}
