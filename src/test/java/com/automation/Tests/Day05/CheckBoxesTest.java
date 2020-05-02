package com.automation.Tests.Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        //#TASK
        //verify that 1st checkbox is not selected and 2nd is selected

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if ((!checkBoxes.get(0).isSelected()) && checkBoxes.get(1).isSelected()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //let's click on the first checkbox and verify it's clicked

        checkBoxes.get(0).click();
        if (checkBoxes.get(0).isSelected()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();


    }
}
