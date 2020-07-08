package com.automation.Tests.Day11;

import com.automation.Utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        BrowserUtils.wait(5);
        //you need to cast if reference type is a WebDriver
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
        //x,y coordinates
        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }


    }

    @Test
    public void scrollToElementTest() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView - javascript method
        //arguments[0] - means 1st WebElement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);


    }
}
