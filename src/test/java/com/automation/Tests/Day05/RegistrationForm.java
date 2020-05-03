package com.automation.Tests.Day05;

import com.automation.Utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(2);

        driver.findElement(By.name("firstname")).sendKeys("Tugce");
        driver.findElement(By.name("lastname")).sendKeys("Aydogan");
        driver.findElement(By.name("username")).sendKeys("tgcydgn");
        driver.findElement(By.name("email")).sendKeys("tgcaydogan@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("tugce1598");
        driver.findElement(By.name("phone")).sendKeys("929-228-6192");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(1).click(); // select female

        driver.findElement(By.name("birthday")).sendKeys("07/26/1992");

        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);

        driver.quit();

    }
}
