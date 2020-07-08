package com.automation.Tests.Vytrack.Activities;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private Actions actions;

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBy = By.cssSelector("a[title='Log call']");


    @Test
    public void verifyLogCallButton() {

        WebElement logCallButtonElement = driver.findElement(logCallBy);
        Assert.assertTrue(logCallButtonElement.isDisplayed());


    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();

        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(5);

        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


}
