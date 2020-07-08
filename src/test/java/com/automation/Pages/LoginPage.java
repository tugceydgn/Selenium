package com.automation.Pages;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.ConfigurationReader;
import com.automation.Utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    public LoginPage() {
        //to connect our WebDriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version #1
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageLoad(20);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */

    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), (Keys.ENTER));
        BrowserUtils.waitForPageLoad(20);
        BrowserUtils.wait(3);

    }


}
