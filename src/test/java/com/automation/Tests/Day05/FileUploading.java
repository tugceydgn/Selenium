package com.automation.Tests.Day05;

import com.automation.Utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir") + "/pom.xml";
        System.out.println(filePath); //print path

        //it works only for my computer because only have this file
        //and my computer username is different than yours
        String file2Path = "C:\\Users\\TUGCE\\Downloads\\2020-02-27 18-12-28.mkv"; //should be correct

        upload.sendKeys(file2Path);

        driver.findElement(By.id("file-submit")).click(); //click to upload

        BrowserUtils.wait(3);
        driver.quit();


    }
}
