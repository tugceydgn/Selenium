package com.automation.Tests.Day06;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide webElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        //and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("January");
        selectDay.selectByVisibleText("25");

        //select all months one by one
        //.getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth : months) {
            //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(5);
        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("Texas");

        //option that is currently selected
        //.getFirstSelectedOption() - returns a WebElement, that's why we need to call .getText() method
        //.getText retrieves visible text from the WebElement
        String selected = selectState.getFirstSelectedOption().getText();
        if (selected.equals("Texas")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = selectState.getOptions();
        for (WebElement eachState : states) {
            System.out.println(eachState.getText());
        }


        BrowserUtils.wait(2);
        driver.quit();


    }
}
