package com.automation.Tests.Vytrack;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.ConfigurationReader;
import com.automation.Utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    //@Optional - to make parameter optional
    //if you don't specify it, testing will require to specify this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("Report name: " + reportName);
        String reportNameString = reportName == null ? "report.html" : reportName + ".html";
        report = new ExtentReports();
        String reportPath = "";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportNameString;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportNameString;
        }


        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void teardownTest() {
        report.flush(); //to release a report
    }

    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());


    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult  class describes the result of a test.
        //If test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); //attach test name that failed
            test.fail(iTestResult.getThrowable()); //attach console output
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath); //attach screenshot
        } else {
            test.pass(iTestResult.getName());
        }


        BrowserUtils.wait(1);
        Driver.closeDriver();
    }

}
