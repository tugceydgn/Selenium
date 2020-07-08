package com.automation.Pages.Activities;

import com.automation.Pages.AbstractPageBase;
import com.automation.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;


    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/p")
    private WebElement generalInfoDescription;

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String descriptionValue) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(descriptionValue);
        driver.switchTo().defaultContent(); //exit from the frame
    }


    public void clickOnSaveAndClose() {
        BrowserUtils.waitForPageLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='btn-group pull-right'] > button")));
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitleText() {
        BrowserUtils.waitForPageLoad(10);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescription() {
        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/p")));
        return generalInfoDescription.getText();
    }

    public List<String> getColumnNames() {
        BrowserUtils.waitForPageLoad(20);

        return BrowserUtils.getTextFromWebElements(columnNames);
    }

    public String getOwnerName() {
        BrowserUtils.waitForPageLoad(10);
        //wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent() {

        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }

    public String getStartDate() {
        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime() {
        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        BrowserUtils.scrollTo(startTime);
        return startTime.getAttribute("value");
    }

    public String getEndTime() {
        BrowserUtils.waitForPageLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        BrowserUtils.scrollTo(endTime);
        return endTime.getAttribute("value");
    }


}
