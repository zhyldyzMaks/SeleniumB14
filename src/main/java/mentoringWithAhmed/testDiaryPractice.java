package mentoringWithAhmed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testDiaryPractice {
    public static void main(String[] args) {
/*
NOTE:You can use any locator you want(id,classname,xpath,tagname....)
TASK 1:
1-Navigate to the website http://www.testdiary.com/training/selenium/selenium-test-page/
2-print out selenium test page from website
3-print out the paragraph from the  page
4-Check the selenium box is displayed or not, if it is displayed and not selected then click
5-Click java radio button
6-Click Save
                */

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement header=driver.findElement(By.xpath("//h1[contains(text(), 'Selenium Test Page')]"));
        System.out.println(header.getText().trim());

        WebElement paragraph=driver.findElement(By.xpath("//strong[contains(text(), 'This page')]"));
        System.out.println(paragraph.getText().trim());

        WebElement seleniumBox=driver.findElement(By.id("seleniumbox"));
        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }

        WebElement javaButton=driver.findElement(By.id("java1"));
        javaButton.click();

        WebElement saveButton=driver.findElement(By.xpath("//button[@id='demo']"));
        saveButton.click();

        /*
        TASK 2:HyperLink Task:
1-Click the Test Dairy link with linktext
2-print out the header,title and currentUrl of Test Dairy from opening page
3-Navigate back to main page
4-Click Test Diary Selenium learning with PartialLinkText
5-print out the header,title and currentUrl of Test Dairy from opening page

         */
        WebElement testDiary=driver.findElement(By.linkText("Test Diary"));
        testDiary.click();

        System.out.println(driver.getTitle().trim());
        System.out.println(driver.getCurrentUrl().trim());

        driver.navigate().back();

        WebElement testDiarySelenium=driver.findElement(By.partialLinkText("Test Diary Selenium Learning"));
        System.out.println(testDiarySelenium.getText().trim());

        String actualTitle1=driver.getTitle();
        String expectedTitle1="Selenium Test Page - Test Diary";

        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }

        String actualUrl1=driver.getCurrentUrl();
        String expectedUrl1="http://www.testdiary.com/training/selenium/selenium-test-page/";
        if (actualUrl1.equals(expectedUrl1)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
/*
        TASK 3:Contact Form
        1-Fill the all the boxes (yourname,youremail,subject and your message)
        2-Click save button
        3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."
 */

        WebElement name=driver.findElement(By.xpath("//input[@name='your-name']"));
        name.sendKeys("Jyldyz");

        WebElement email=driver.findElement(By.xpath("//input[@name='your-email']"));
        email.sendKeys("jyl@gmail.com");

        WebElement subject=driver.findElement(By.xpath("//input[@name='your-subject']"));
        subject.sendKeys("Hello");

        WebElement message=driver.findElement(By.xpath("//textarea[@name='your-message']"));
        message.sendKeys("Everything will be good");

        WebElement send=driver.findElement(By.xpath("//input[@type='submit']"));
        send.click();

        WebElement success=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']"));
        String actualMessage=success.getText().trim();
        String expectedMessage="Your message was sent successfully. Thanks.";
        if (actualMessage.equals(expectedMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
