package com.automation.Tests.Day06;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languages = new Select(driver.findElement(By.name("Languages")));
        //whether this select element support selecting multiple options at the same time?
        //this is done by checking the value of the "multiple" attribute.
        boolean isMultiple = languages.isMultiple();
        System.out.println(isMultiple); //-->> if it's true, you can select more than one option
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        //let's get all selected option
        List<WebElement> selectedLanguages = languages.getAllSelectedOptions();

        for (WebElement eachLanguage : selectedLanguages) { //secilmis olanlari yazdiriyor
            System.out.println(eachLanguage.getText());
        }
        BrowserUtils.wait(3);

        languages.selectByVisibleText("Java"); //to unselect something
        BrowserUtils.wait(3);
        languages.deselectAll();


        BrowserUtils.wait(2);
        driver.quit();


    }
}
