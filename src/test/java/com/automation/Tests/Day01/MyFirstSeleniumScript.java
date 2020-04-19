package com.automation.Tests.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

        //setup chromeDriver
        WebDriverManager.chromedriver().setup();
        //create chromeDriver object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");

    }
}
