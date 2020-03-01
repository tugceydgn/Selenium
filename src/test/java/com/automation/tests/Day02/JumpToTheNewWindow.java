package com.automation.tests.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every windows has some id, this id calls window handle
        //based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);

        //getWindowHandles() - returns id's of all currently opened windows
        //Set - doesn't allow duplicates

        Set<String> windowsHandles = driver.getWindowHandles();

        System.out.println(windowsHandles);
        System.out.println("BEFORE SWITCH: " + driver.getCurrentUrl());
        //since we have all window
        //and we know id of original window
        //we can say switch to something that is not equals to old window id

        //since we have all windows
        //and he know if of original window
        //we can say switch to something that is not equals to old window id
        for(String windowId : windowsHandles){
            //if it's not an old window, then switch
            if(!windowId.equals(windowHandle)){
                //to jump to the new window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH: " + driver.getCurrentUrl());
        driver.close();
    }

    public static void switchToWindowBasedOnTitle (String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();
        for(String window :windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
