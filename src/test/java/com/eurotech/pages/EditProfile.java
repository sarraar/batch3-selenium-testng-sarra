package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfile  extends BasePage{

    @FindBy(xpath = "//a[text()='Create Profile']")
    public WebElement createProfile;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement professionalStatusSelect;

    @FindBy(name = "company")
    public WebElement companyInput;

    @FindBy(name = "website")
    public WebElement websiteInput;

    @FindBy(name = "location")
    public WebElement locationInput;

    @FindBy(name = "skills")
    public WebElement skillsInput;


    @FindBy(name = "githubusername")
    public WebElement githubusernameInput;

    @FindBy(name = "bio")
    public WebElement bioInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;

}
