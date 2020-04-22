package com.automation.Tests.Day03;

import com.automation.Utilities.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElementsPractice {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //   WebDriver driver = DriverFactory.createADriver("chrome");

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

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement signUpMessage = driver.findElement(By.name("signup_message"));
        if (expected.equals(signUpMessage.getText())) {  //To get the text <h3>text</h3>
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        driver.quit(); //to close everything


    }
}
