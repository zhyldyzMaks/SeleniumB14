package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestNGPractice {
    @Test
    public void validateTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        String actual = driver.getTitle().trim();
        String expected = "Dashboard";
        Assert.assertEquals(actual,expected);
        //As a good tester please do at least 1 negative scenario like removing letter
    }



    @Test
    public void validateUrl(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        String actualURl=driver.getCurrentUrl();
        String expectedUrl="ttps://demo.opencart.com/admin/";

        //Assert.assertEquals(driver.getCurrentUrl(),true);
        Assert.assertTrue(actualURl.contains(expectedUrl));
    }

    @Test
    public void validateProductCrossButton() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement product=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());

    }

    @Test
    public void productsValidation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(1000);

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement product=driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i =1; i<checkBoxes.size();i++){
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(checkBoxes.get(i).isEnabled());
            Thread.sleep(1000);
            checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxes.get(i).isSelected());

        }
    }
    @Test
    public void productNameValidation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        //Thread.sleep(1000);

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement products=driver.findElement(By.xpath("//a[.='Products']"));
        products.click();

        WebElement productNameButton=driver.findElement(By.xpath("//a[@class='asc']"));
        productNameButton.click();

        Thread.sleep(1000);
        ArrayList <String> actualList=new ArrayList<>();
        ArrayList<String> expectedList=new ArrayList<>();
        List<WebElement> allBrands =driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i<allBrands.size();i++){
            Thread.sleep(1000);
            actualList.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedList.add(allBrands.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(actualList);
        System.out.println(expectedList);
        Assert.assertEquals(actualList,expectedList);


    }
    @Test
    public void ascendingOrderValidation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        //Thread.sleep(1000);

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement products=driver.findElement(By.xpath("//a[.='Products']"));
        products.click();

        Thread.sleep(1000);
        ArrayList <String> actualList=new ArrayList<>();
        ArrayList<String> expectedList=new ArrayList<>();
        List<WebElement> allBrands =driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i<allBrands.size();i++){
            Thread.sleep(1000);
            actualList.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedList.add(allBrands.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedList);
        System.out.println(actualList);
        System.out.println(expectedList);
        Assert.assertEquals(actualList,expectedList);


    }


    @Test
    public void firstCheckBoxValidation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(1000);

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement product=driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkBoxes.get(0).click();
        for (int i =1; i<checkBoxes.size();i++){
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(checkBoxes.get(i).isSelected());

        }
        checkBoxes.get(0).click();
        for (int i =1; i<checkBoxes.size();i++){
            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(!checkBoxes.get(i).isSelected());

        }
    }

    @Test
    public void productValidation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement name = driver.findElement(By.xpath("//input[@id='input-username']"));
        name.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        //Thread.sleep(1000);

        WebElement xButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog=driver.findElement(By.id("menu-catalog"));
        catalog.click();

        WebElement products=driver.findElement(By.xpath("//a[.='Products']"));
        products.click();

        WebElement productNameButton=driver.findElement(By.xpath("//a[@class='asc']"));
        productNameButton.click();
        WebElement descendingOrder=driver.findElement(By.xpath("//a[@class='desc']"));
        descendingOrder.click();

        Thread.sleep(1000);
        ArrayList <String> actualList=new ArrayList<>();
        ArrayList<String> expectedList=new ArrayList<>();
        List<WebElement> allBrands =driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i<allBrands.size();i++){
            Thread.sleep(1000);
            actualList.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedList.add(allBrands.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedList);
        //Collections.reverse(expectedList);
        System.out.println(actualList);
        System.out.println(expectedList);
        Assert.assertEquals(actualList,expectedList);


    }

}
