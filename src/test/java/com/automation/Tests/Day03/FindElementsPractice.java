package com.automation.Tests.Day03;

import com.automation.Utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindElementsPractice {

    public static void main(String[] args) throws Exception {

        //    WebDriverManager.chromedriver().setup();
        //  WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Tugce Aydogan");
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("tgcaydogan@hotmail.com");
        Thread.sleep(3000);

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        //when you see type-"submit", you can use submit() instead of click()
        // it make sense to use when click() method doesn't work
        signUpButton.submit();
        Thread.sleep(2000);

        WebElement signUpMessage = driver.findElement(By.name("signup_message"));
        System.out.println(signUpMessage.getText());


        driver.quit(); //to close everything


    }
}
