package com.automation.Tests.Day08;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Create a class called PracticeTest
 * <p>
 * - setup before/after methods
 * - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 * - in after method - just close driver
 * <p>
 * - create a test called loginTest
 * - go to "Form Authentication" page
 * - enter valid credentials
 * username: tamsmith
 * password: SuperSecretPassword
 * - verify that following sub-header message is displayed: :"Welcome to the Secure Area. When you are done click logout below."
 */

public class PracticeTests {


    private WebDriver driver;

    @Test
    public void loginTest() {

        driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        BrowserUtils.wait(3);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(3);
        driver.findElement(By.id("wooden_spoon")).submit();

        String actual = driver.findElement(By.tagName("h4")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, message in case of error)
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    /*
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enter his email
     * And clicks "Retrieve password button
     * Then user verifies that message "Your email's been sent!" is displayed
     * */
    @Test
    public void forgotPasswordTest() {
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(5);

        driver.findElement(By.name("email")).sendKeys("tgcaydogan@hotmail.com");
        driver.findElement(By.id("form_submit")).submit();

        BrowserUtils.wait(2);

        String actual = driver.findElement(By.name("confirmation_message")).getText();
        String expected = "Your e-mail's been sent!";
        Assert.assertEquals(actual, expected, "Confirmation message is not valid!");

    }

    @Test

    public void checkboxesTest() {
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);
        WebElement cbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        cbox1.click();
        Assert.assertTrue(cbox1.isSelected(), "it is not selected!");
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
