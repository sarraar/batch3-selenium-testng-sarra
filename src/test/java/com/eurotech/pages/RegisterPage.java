package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(name = "name")
    public WebElement nameRegister;

    @FindBy(name = "email")
    public WebElement emailRegister;

    @FindBy(name = "password")
    public WebElement passwordRegister;

    @FindBy(name = "password2")
    public WebElement password2Register;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInBtn;

    //Create profile

    @FindBy(xpath = "//a[text()='Create Profile']")
    public WebElement createProfile;

    //Methods

    public void signIn(String name, String email, String password, String password2) {

        RegisterPage registerPage = new RegisterPage();
        registerPage.understandBtn.click();
        registerPage.signUp.click();
        registerPage.nameRegister.sendKeys(name);
        registerPage.emailRegister.sendKeys(email);
        registerPage.passwordRegister.sendKeys(password);
        registerPage.password2Register.sendKeys(password2);
        registerPage.signInBtn.click();

    }

}
