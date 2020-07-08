package com.automation.Tests.Day13;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUpTask {

    //Go to http://practice.cybertekschool.com/tables
    //Click on "Last name" column name
    //Verify that table is sorted by last name in alphabetic order

    private WebDriver driver;
    String URL = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().window().maximize();

    }

    /**
     * The Java String compareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     * <p>
     * This method is coming from Comparable interface
     * If you want to be able to sort collection of some class
     * You need to implement this interface
     * and override compareTo method
     * <p>
     * "a".compareTo("b") = -1
     * 61 - 62 = -1    -->> ascii table a gore
     * a is before b
     * "a".compareTo("a")
     * 61-61 = 0
     * 0 means 2 strings are equals
     **/

    @Test
    public void sortedLastName() {

        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(5);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equal
            Assert.assertTrue(value.compareTo(nextValue) <= 0);

        }


    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
