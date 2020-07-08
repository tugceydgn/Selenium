package com.automation.Tests.Vytrack.Activities;

import com.automation.Pages.Activities.CalendarEventPage;
import com.automation.Pages.LoginPage;
import com.automation.Tests.Vytrack.AbstractTestBase;
import com.automation.Utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventPage calendarEventPage = new CalendarEventPage();

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     **/


    @Test
    public void defaultOptionsTest() {
        test = report.createTest("Verify default options");
        LoginPage loginPage = new LoginPage();
        CalendarEventPage calendarEventPage = new CalendarEventPage();
        loginPage.login();
        calendarEventPage.navigateTo("Activities", "Calendar Events");

        calendarEventPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventPage.getOwnerName(), calendarEventPage.getCurrentUserName());

        String actualStartDate = calendarEventPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM d, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
        test.pass("Default options are default");
    }


    @Test
    public void timeDifferenceTest() {
        test = report.createTest("Verify an hour difference between times");
        LoginPage loginPage = new LoginPage();
        CalendarEventPage calendarEventPage = new CalendarEventPage();
        loginPage.login();
        calendarEventPage.navigateTo("Activities", "Calendar Events");
        calendarEventPage.clickToCreateCalendarEvent();

        String startTime = calendarEventPage.getStartTime();
        String endTime = calendarEventPage.getEndTime();
        String format = "h:m a";
        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

        Assert.assertEquals(actual, 1, "Time difference is not correct");
        test.pass("There is an hour difference between times");

    }


    @Test
    public void columnNamesTest() {
        test = report.createTest("Verify column names");
        LoginPage loginPage = new LoginPage();
        CalendarEventPage calendarEventPage = new CalendarEventPage();
        loginPage.login();
        calendarEventPage.navigateTo("Activities", "Calendar Events");
        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventPage.getColumnNames(), expected);
        test.pass("Column names are equals with the expected");
    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description) {


        //just create page objects inside a test
        LoginPage loginPage = new LoginPage();
        CalendarEventPage calendarEventPage = new CalendarEventPage();
        //only for extent report. To create a test in html report.
        test = report.createTest("Create Calendar Event");
        loginPage.login();
        calendarEventPage.navigateTo("Activities", "Calendar Events");
        calendarEventPage.clickToCreateCalendarEvent();
        calendarEventPage.enterCalendarEventTitle(title);
        calendarEventPage.enterCalendarEventDescription(description);
        calendarEventPage.clickOnSaveAndClose();

        Assert.assertEquals(calendarEventPage.getGeneralInfoDescription(), description);
        Assert.assertEquals(calendarEventPage.getGeneralInfoTitleText(), title);
        test.pass("Calendar event was created successfully!");
    }


    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"},
                {"Sprint Review", "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}
        };
    }


}
