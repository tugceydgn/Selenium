package com.automation.Tests.Day07;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]";


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();


        BrowserUtils.wait(2);
        driver.quit();


    }

}
