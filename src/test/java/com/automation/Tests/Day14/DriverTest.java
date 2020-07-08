package com.automation.Tests.Day14;

import com.automation.Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest() {
        //Driver.getDriver() --->> returns driver
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        Driver.closeDriver();
    }
}
