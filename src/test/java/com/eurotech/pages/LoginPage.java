package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtnLoginPage;

    @FindBy(partialLinkText = "Forgot")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[text()='Invalid Credentials!']")
    public WebElement invalidText;

    public void loginTeacher() {

        String email = ConfigurationReader.get("usernameTeacher");
        String password = ConfigurationReader.get("passwordTeacher");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtnLoginPage.click();

    }

    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void login2(String username, String password){

        understandBtn.click();
        loginBtnBasePage.click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtnLoginPage.click();
    }


}
