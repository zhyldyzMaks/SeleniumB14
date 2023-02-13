package seleniumRecap;

public class InterviewQuestions {

    /*
    1-What are the advantages and disadvantages of Selenium?

      Advantages:    * Free open source
                     * It supports multiple languages (Java,Python,C++)
                     * It supports multiple browsers (Chrome,Firefox,Safari ... etc)

      Disadvantages: * You cannot automate the captcha, pictures, mobile apps ... (APPIUM)
                     * There is no direct call for th error(support center)
                     * It automates only web applications
                     * It doesn't have any system to generate report, so we use TestNG report system

     2-What type of testing can you automate with Selenium?
        * Regression
        * Smoke
        * Functional (positive, negative ... etc)

     3-What are the test types do not automate with Selenium?
        * Performance Testing
        * Manual Testing
        * Non-Functional Testing (performance, stress, load etc.)

     4-What are the Locator types do you know in Selenium? Which one do you use the most?
        * Locator is a way to find elements from DOM (development tool page)
        * The locators are: ID, ClassName, Name, TagName, LinkText, PartialLinkText, Xpath, Css
        * I mostly use CSS and XPATH since they are really fast and useful.

     5-How do you handle dynamic elements? (CVS ... etc).
        * In my project I faced many dynamic elements (Facebook) and I  use different ways
          to handle with based on my "RESEARCH"
        * I use parent-child relationship to locate the elements
        * I use different attributes to locate element which is not dynamic
        * I use special Xpath methods to handle it (following-siblings, contains, .=, preceding siblings)

     6-What is the difference between driver.get() and driver.navigate()?
                          driver.get()
        * It goes to the website and wait for all elements to be loaded then continue

                          driver.navigate().to()
        * It goes to the website but waits for only the certain elements that you are looking for on the page
        * It has some methods (to, refresh, back, forward)

     7-What is the difference between driver.close and driver.quit?
                           driver.close
        * It closes the only page that driver pointing (GetWindowHandle)

                           driver.quit
        * No matter It closes the all pages that opened during automation

     8-What is xpath? Can you tell me about the types of Xpath? Which one do you use in your framework?
        * Xpath is used to find the location of the elements on the webpage by using an HTML structure.
        * There are 2 types of Xpath: Absolute and Relative Xpath
        --> Absolute Xpath goes all the way from parent to child step by step (/html/div/img/a/p)
            It uses single slash (/)
        --> Relative Xpath it directly or parent to child to find the element (//a[contains] or div[@id='value']//a
            It uses double slash (//)

        * In my project I mostly use relative xpath, bec it directly focuses on the child which I need to locate.

     9-What is the difference between Absolute and Relative xpath?
         Absolute: from all the way parent to child, single slash, syntax is different

         Relative: directly to child or parent-child, double slash, syntax is different

     10-How do you handle dropDowns?
         * In my project I was handling drop-down with different ways.
         1-I would definitely check the tag name of the location. If tagName is "select" (Select select = new Select(location).
         2-If the location doesn't have select tag name. I just find the element and sendKeys.
         3-I can also use ACTIONS class to hoverOver my element (moveToElement.perform).

     11-What kind of methods do you use for Select class?
         * Select class is really useful for my project. To be able to use Select class, element must have select tag name.
           I can locate the elements by using these methods:
            1-SelectByVisibleText
            2-SelectByValue
            3-SelectByIndex

          NOTE: I generally call my BrowserUtils(class I store reusable methods) method which takes care of these types.

     12-What kind of exceptions have you ever faced during UI automation?
         * NoSuchElement Exception --> path is wrong, different window, iframe, wait times.
         * NullPointer Exception   --> driver or webpage are not initialized.
         * StaleElementReference Exception  --> dom is updated or refreshed, changing the values on dom
         * ElementNotIntractable --> Element is not visible on the page (Scroll down solution)
         * TimeOut Exception --> Wait time problem
         * NoSuchFrame Exception --> frame path is wrong
         * AlertUnhandled Exception --> when you try to switch the alert (driver) and no alert at the moment it will throw this exception.

     13-In what condition do you get StaleElementReference Ex? How do you handle it?
         * In my project I had a hard time with StaleElementRef exc to handle.
           -->Once the element is not in DOM anymore
           -->Once the element is updated (changed) the values in DOM

           3 ways to handle:
           1-Reassigning the webElement
           2-Thread.sleep before staleElement exc
           3-Refresh the page

      14-How do you handle the alerts?
         These are different types of alerts I faced in my framework?
         1-Operation System Alert(OS): I cannot handle it directly. I need to use "ROBOT CLASS"
         2-HTML Alert: I just need to find the element and click on it.
         3-JS Alert: I handle this alert pop-up with ALERT INTERFACE.
           Alert alert =driver.switchTo().alert();

      15-What kind of methods do you use to handle JS alert?
         Alert is an Interface. It has some methods to handle JS pop-ups.
          Alert alert =driver.switchTo().alert();
          alert.accept() --> OK
          alert.dismiss() --> Cancel
          alert.getText() --> get text from JS alert
          alert.sendKeys() --> sends key to JS alert

      16-What do you know about iframe? Type that used before and how do you handle the iframe in Selenium?
        SCENARIO: Here is the scenario, we have a website and I would like to get the text of price from products.
        All xpath is correct and there is no problem with windows, but I am still having issue to get the text from website.
        What would be your approach to handle this issue?

        NOTE: iframe is basically html inside html. The reason could people are using iframe to encapsulate some ads, videos, docs

        The reason could be iframe, I would go to the website and check the html has an iframe tag name or not by typing (//iframe)
        If there is frame/iframe on html, I would check that my element is under this frame or not.

      17-What do you know about Actions class?
         Actions class bas does the functionality of Mouse. It is useful in my project to handle some drop-down and do some mouse actions:
         * moveToElement.perform
         * dragAndDrop.perform
         * clickAndHold.release.perform
         * contextClick.perform
         * doubleClick.perform
         * sendKeys.perform

      18-What is difference between findElement and findElements?
         findElement:   driver.findElement(By...)
                        return the single webElement
                        NoSuchElement Exception

         findWElements: driver.findElements(By...)
                        return the List of webElements
                        Doesn't give exception

      19-What are the driver and webElement methods do you use in your framework?
           Driver Methods: get, navigate, getTitle, findElement/s, getCurrentUrl, getPageSource, manage,
                           getWindowHandle, switchTo, close, quit.

           WebElement methods: sendKeys, click, getText, clear, isDisplayed, isSelected, isEnabled, submit, getAttribute, getCssValue.

      20-What is the difference between check-box and radio button?
           CheckBox: you can click multiple box at the time.

           Radio button: you can choose only one. Male/Female button.

      21-What is difference between isDisplayed, isSelected and isEnabled?
          All of them return Boolean condition:
          isDisplayed: it checks the element is visible on the page or not.
          isSelected: it checks the element (box or radio button) selected or not.
          isEnabled: it checks the element is enabled to click or not.

      22-How do you switch/handle windows?
          I can use driver.getWindowHandle/s method to switch my windows/tabs and handle the elements which is in other windows.
          I have BrowserUtils that has specific implementation to handle it.
          I use contains method for title/url to switch my window (BrowserUtils class).
          driver.switchTo().window(id)

      23-Difference between them?
         getWindowHandle: returns the id of a page (String id)

         getWindowHandles: returns the Set<String>

      24-How do you scroll down/up in the webpage?
         I would use JS "ScrollINTOVIEW" method
         Actions class --> scrollByAmount(x,y)
         Keys class --> ARROW_UP, ARROW_DOWN

      25-How do upload and download file in sSelenium?
         Upload File: We need to find the ChooseFile button to trigger the OS pop-up.
         Find the location of file (we need to update from your computer) (/C://desktop/usa.png)
         chooseFile.sendKeys(location of file) (above)

      26-What is the difference between Assert and SoftAssert?
         Assert: is a class that has some methods to validate actual and expected values.
         When it fails throws an exception right away then stop the execution for next line of code.

         SoftAssert: is a class that hase some extra methods (assertAll) to validate actual and expected values.
         When it fails it doesn't throw an exception right away and keeps execution.
         To be able to activate softAssert you need to create an object.
         Then you need to use softAssertAll()

         SoftAssert softAssert = new SoftAssert();
          --> softAssert.AssertAll();

       27-Can you tell me about Singleton?
          First of all I appreciate for this question since I like the Singleton pattern design logic in my framework.
          While I was working on some test cases, I was struggling with "NullPointerException" many times because my
          driver was not centralized. With the help of Singleton the amount of Exception dramatically reduced which
          saved my time and effort an automation-testing.

          How to create Singleton Design:
            1-I need to have private Constructor.
            2-I create public static method to call from classes.(DriverHelper.getDriver).
            3-I use if condition to check my "STATUS OF DRIVER" (it is null or not).

       28-What do you know about TestNG annotations?
          @Test --> executes my codes
          @BeforeMethod --> runs before every test annotation
          @AfterMethod --> runs after every test annotation
          @Parameters --> provides parameters from xml file
          @DataProvider --> runs same test with different set of data.

       29-How do you handle wait time issues in your project?
          Implicitly Wait
          Explicitly Wait
          Fluent Wait

       30-Can you tell me how provide pictures once you find the bug?
          In my project I have good implementation for the screenshot. It means once any test fails I follow the bug
          cycle and during that process I use screenshot as a guidance to identify the problem.
          --> Talk about Bug Cycle (SOFT SKILL CLASS).
     */
}
