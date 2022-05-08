package com.eurotech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    public WebElement usernameInput;

    @FindBy(id="password")
    public WebElement passwordInput;

//    @FindBy(id="login-button")
//    public WebElement loginButton;

    //bunu VEYA !! bunu bul
//    @FindAll({
//            @FindBy(id="login-button"),
//            @FindBy(name="login-button")
//    })
//    public WebElement loginButton;

    // bunu VE !! bunu bul
    @FindBys({
            @FindBy(id="login-button"),
            @FindBy(name="login-button")
    })
    public WebElement loginButton;





}
