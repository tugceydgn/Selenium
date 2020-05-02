package com.automation.Tests.Day05;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        //<input type="checkbox" checked"">
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        checkBoxes.get(0).click(); // click on first checkbox

        BrowserUtils.wait(2);
        //go over collection of checkboxes
        for (int i = 0; i < checkBoxes.size(); i++) {

            //         if visible,                       eligible to click and            not clicked yet
            if (checkBoxes.get(1).isDisplayed() && checkBoxes.get(1).isEnabled() && (!checkBoxes.get(1).isSelected())) {
                //if checkbox is not selected, don't click
                // checkBoxes.get(i).click(); // click on it
            } else {
                System.out.println(i + 1 + " checkbox wasn't clicked!");
            }
        }
        BrowserUtils.wait(2);

        driver.quit();


    }
}
