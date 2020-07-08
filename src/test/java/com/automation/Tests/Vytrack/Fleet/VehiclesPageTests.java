package com.automation.Tests.Vytrack.Fleet;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

import static org.testng.Assert.*;

public class VehiclesPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span");
    private By subTitleBy = By.className("oro-subtitle");
    private By pageNumber = By.xpath("//label[text()='Page:']/..//input");

    @Test
    public void verifyPageSubTitle() {

        //find subtitle Element
        WebElement subTitleElement = driver.findElement(subTitleBy);
        System.out.println(subTitleElement.getText());

        String expected = "All Cars";
        String actual = subTitleElement.getText();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void verifyPageNumber() {

        WebElement pageNumberText = driver.findElement(pageNumber);
        BrowserUtils.wait(10);
        String expected = "1";
        String actual = pageNumberText.getAttribute("value"); //because it's a value
        Assert.assertEquals(expected, actual);


    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        //put more wait here as well, if didn't click
        BrowserUtils.wait(5);
        //click on fleet
        //  driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        //move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).pause(5000).build().perform();

        //perform - to execute command
        //every action should end with perform()
        BrowserUtils.wait(10);

        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is sloooow...
        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
