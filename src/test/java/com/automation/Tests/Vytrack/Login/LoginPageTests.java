package com.automation.Tests.Vytrack.Login;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//STATIC IMPORT OF ALL ASSERTIONS
import java.security.Key;

import static org.testng.Assert.*;  // it helps you don't have to call Assert.assertTrue() -->> just call assertTrue()

public class LoginPageTests {
    private WebDriver driver;
    // https is secured version of http protocol
    // https - data encrypted, no chance for hackers to retrieve info
    // http - it's hypertext transfer protocol that every single website is using now days
    // http - data as a plain text, very easy o hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    // Credentials for Store Manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]");

    @Test(description = "Verify that warning message displays when user enters invalid username")
    public void invalidUsername() {

        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("USerUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password";
        String actual = warningElement.getText();
        assertEquals(expected, actual);
    }

    @Test(description = "Login as store manager and verify that tile is equals to Dashboard")
    public void loginAsStoreManager() {

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(expected, actual);

    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("firefox");
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() {
        //if WebDriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy driver object for sure
            driver = null;
        }

    }


}
