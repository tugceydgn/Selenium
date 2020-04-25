package com.automation.Tests.Day04;

import com.automation.Utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WarmUp {

    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {


        ebayTest();
        amazonTest();
        wikiTest();

    }

    /*Go to Ebay
    Enter search term
    Click on search button
    Print number of results*/
    public static void ebayTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book", Keys.ENTER);

        WebElement numberOfResult = driver.findElement(By.tagName("h1"));
        System.out.println(numberOfResult.getText().split(" ")[0]);

        driver.quit();

    }

    /*Go to amazon
    Enter search term
    Click on search button
    Verify title contains search term*/
    public static void amazonTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");

        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("computer", Keys.ENTER);
        Thread.sleep(2000);
        String amazonTitle = driver.getTitle();
        if (amazonTitle.contains("computer")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        System.out.println(amazonTitle);

        driver.quit();
    }

    /*Go to wikipedia.org
    Enter search term 'selenium webdriver'
    Click on search button
    Click on search result 'Selenium (software)'
    verify url ends with 'Selenium_(software)'*/
    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);

        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl();
        if (link.endsWith("Selenium_(software)")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        System.out.println(link);

        driver.quit();
    }


}
