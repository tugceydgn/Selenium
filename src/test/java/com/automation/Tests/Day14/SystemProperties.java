package com.automation.Tests.Day14;

import org.testng.annotations.Test;

public class SystemProperties {


    @Test
    public void Test() {
        // C:\Users\TUGCE\IntelliJIDEAProjects\Fall2019Selenium\pom.xml
        // System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        //flexible path to downloads folder
        //System.getProperty("user.home") + "/Downloads"
        System.out.println(System.getProperty("user.home"));
        //for windows , use \\ instead of /
        String pathToDownloads = System.getProperty("user.home") + "/Downloads";
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));

        //http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html


    }
}
