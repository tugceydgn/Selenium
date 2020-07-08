package com.automation.Tests.Vytrack.Login;

import com.automation.Pages.LoginPage;
import com.automation.Tests.Vytrack.AbstractTestBase;
import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.Driver;
import com.automation.Utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is a "Dashboard"
     */

    @Test(groups = "smoke")
    public void verifyPageTitle() {
        //test --> ExtentTest object
        //test = report.createTest("Test name");
        //we must add to every test at the beginning
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as a store manager");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");

    }

    /**
     * Enter wrong credentials and verify warning message
     */

    @Test
    public void verifyWarningMessage() {
        test = report.createTest("Verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning message is displayed");
    }


    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) {
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified.");


    }

    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel(String execute, String username, String password, String firstName, String lastName, String result) {
        test = report.createTest("Login test for username :: " + username);
        if (execute.equals("y")) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as " + username);
            test.pass("Successfully logged in as " + username);
            test.info(String.format("First name: %s, Last name: %s, Username: %s", firstName, lastName, username));
        } else {
            test.skip("Test was skipped for user: " + username);
            throw new SkipException("Test was skipped for user: " + username);
        }
    }

    @DataProvider
    public Object[][] credentialsFromExcel() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return excelUtil.getDataArray();
    }

    //Object[][] or Object[] or Iterator<Object[]>
    //Object[]-1 column with a data
    //Object[][] 2+

    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"},
        };
    }

}
