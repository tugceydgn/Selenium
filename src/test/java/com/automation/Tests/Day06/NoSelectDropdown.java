package com.automation.Tests.Day06;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown

        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }

        driver.findElement(By.linkText("Amazon")).click(); //click on option


        BrowserUtils.wait(2);
        driver.quit();


    }
}
