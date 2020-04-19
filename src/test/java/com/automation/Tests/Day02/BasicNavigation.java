package com.automation.Tests.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        //setup WebDriver (browser driver) and create WebDriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //In selenium, everything starts from WebDriver interface'
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");//to open a website
        driver.manage().window().maximize();//to maximize browser
//        driver.manage().window().fullscreen();
        Thread.sleep(3000);//for demo, wait 3 seconds
        //method that return page title
        //you can also see it as tab name, in the browser
        String title = driver.getTitle();//returns <title>Some title</title> text
        String expectedTitle = "Google";//we provide it
        System.out.println("Title is..." + title);
        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        //go to another website within the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);//for demo, wait 3 seconds
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }
}