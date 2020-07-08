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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Scenario-2: Verify for store manager
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed
 */

public class CalendarEventsPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @Test
    public void verifyCreateCalendarEventButton() {
        WebElement calendarEventButtonElement = driver.findElement(createCalendarBy);
        Assert.assertTrue(calendarEventButtonElement.isDisplayed());

    }

    /**
     * in the @BeforeMethod
     * Test Case: Default options
     * Login as sale manager
     * Go to Activities -->> Calendar Events
     * <p>
     * <p>
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */

    @Test(description = "Default options")
    public void verifyDefaultValues() {
        //Click on Create Calendar Event
        driver.findElement(createCalendarBy).click();
        BrowserUtils.wait(4);

        // Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String ownerUserName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName, ownerUserName);
        // Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        // Default start date should be current date

        String expectedDate = LocalDate.now(ZoneId.of("GMT-5")).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(expectedTime, actualTime);

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

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


}


