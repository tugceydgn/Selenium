package com.automation.Tests.Twitter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Deneme {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://twitter.com");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("session[username_or_email]"));
        username.sendKeys("tugceydgnplt");

        WebElement password = driver.findElement(By.name("session[password]"));
        password.sendKeys("Derin2019.");

        WebElement search = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div[1]/form/div/div[3]/div"));
        search.submit();

        Thread.sleep(3);

        WebElement messages = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div/header/div/div/div/div/div[2]/nav/a[4]/div"));
        messages.click();

        WebElement bulent = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div/main/div/div/div/section[2]/div/div/a"));
        bulent.click();


        //NewMessage Search Tab
        WebElement searching = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/form/div[1]/div/div/div[2]/input"));
        searching.sendKeys("blntpltttt");
        Thread.sleep(3);

        //choosing person to send message
        WebElement blntplttt = driver.findElement(By.cssSelector("#typeaheadDropdown-2 > div:nth-child(2) > div > div"));
        blntplttt.click();

        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[3]/div/div"));
        nextButton.click();


        Thread.sleep(3);
        WebElement msg1 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
        msg1.sendKeys("sen benim herseyimsin");

        Thread.sleep(2);
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        Thread.sleep(3);
        sendButton.sendKeys(Keys.ENTER);


        Thread.sleep(3);
        driver.quit();


    }
}
