package com.automation.Tests.Vytrack.Fleet;

import com.automation.Pages.Fleet.VehiclesPage;
import com.automation.Pages.LoginPage;
import com.automation.Tests.Vytrack.AbstractTestBase;
import com.automation.Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends AbstractTestBase {

    @Test
    public void verifyTitle() {
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
