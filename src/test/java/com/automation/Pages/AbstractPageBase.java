package com.automation.Pages;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class will be extended by page classes
 * Ant common WebElements/Locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */


public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 15);

    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;


    public AbstractPageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getCurrentUserName() {
        BrowserUtils.waitForPageLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * Method for Vytrack navigation. Provide tab name and module name to navigate
     *
     * @param tabName,    like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles Odometer and Vehicles Costs
     */


    public void navigateTo(String tabName, String moduleName) {

        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);
        BrowserUtils.wait(5);
        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();

        BrowserUtils.wait(5);

    }


}