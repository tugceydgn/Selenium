package com.automation.Tests.Day13;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    /*
     * Go to web orders page
     * Click on "Check All" button
     * Verify that all records are selected
     * */

    @Test
    public void checkBoxTest() {

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox]"));
        for (WebElement checkbox : checkboxes) {

            Assert.assertTrue(checkbox.isSelected());
        }

    }


    @Test
    public void updateZipCode() {
        /*
         * Go to web orders page
         * Verify that Steve Johns zip code is 21233
         * Then update his zip code to 20002
         * Then verify that Steve Johns zip code is 20002
         * */

        String expected = "21233";
        WebElement zipCode = driver.findElement(By.xpath("//tr[4]//td[9]"));
        Assert.assertEquals(zipCode.getText(), expected);

        WebElement editBtn = driver.findElement(By.xpath("//tr[4]//td[13]"));
        editBtn.click();


        WebElement zipCodeEdit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCodeEdit.clear();

        zipCodeEdit.sendKeys("20002");


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();


        String expected2 = "20002";
        zipCode = driver.findElement(By.xpath("//tr[4]//td[9]"));
        Assert.assertEquals(zipCode.getText(), expected2);


    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
