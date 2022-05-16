package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddExperience extends BasePage {
    @FindBy(name = "title")
    public WebElement addJobTitle;

    @FindBy(name = "company")
    public WebElement addCompany;

    @FindBy(name = "location")
    public WebElement addLocation;

    @FindBy(xpath = "(//input[@type='date'])[1]")
    public WebElement addFromDate;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement currentJob;

    @FindBy(xpath = "(//input[@type='date'])[2]")
    public WebElement addToDate;

    @FindBy(name = "description")
    public WebElement addDescription;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;


}
