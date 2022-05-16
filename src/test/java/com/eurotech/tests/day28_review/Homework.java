package com.eurotech.tests.day28_review;

import com.eurotech.pages.*;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static com.eurotech.utilities.BrowserUtils.hover;

public class Homework extends TestBase {
    /*
    --Create new user
    --Add new user's info to configuration properties
           --> Test 2
          --Login with new user
          --Edit profile ( student,learning, city, skills)
          --click submit
          --Verify that profile updated //scrolltoElement kullan verifyda
          --go back
          --Add experiences
          --Submit
                            -->Test3
                            --Verify that all user's infos
     */

    @Test
    public void createUser() {
        extentLogger = report.createTest("Create user test");
        RegisterPage registerPage = new RegisterPage();
        EditProfile editProfile = new EditProfile();

        extentLogger.info("Click understand button");
        registerPage.understandBtn.click();

        extentLogger.info("Click signUp button");
        registerPage.signUp.click();

        extentLogger.info("Enter Username");
        registerPage.nameRegister.sendKeys("Sar");

        extentLogger.info("Enter an email address");
        registerPage.emailRegister.sendKeys("sar@gmail.com");

        extentLogger.info("Enter a password");
        registerPage.passwordRegister.sendKeys("123456");

        extentLogger.info("Confirm password");
        registerPage.password2Register.sendKeys("123456");

        extentLogger.info("Click submit button");
        registerPage.signInBtn.click();

        extentLogger.info("Click create profile button");
        registerPage.createProfile.click();

        extentLogger.info("Select professional status");
        Select select = new Select(editProfile.professionalStatusSelect);
        select.selectByVisibleText("Developer");

        extentLogger.info("Add company");
        editProfile.companyInput.sendKeys("Microsoft");

        extentLogger.info("Add website");
        editProfile.websiteInput.sendKeys("sarra.microsoft.de");

        extentLogger.info("Add location");
        editProfile.locationInput.sendKeys("LA");

        extentLogger.info("Add skills");
        editProfile.skillsInput.sendKeys("HTML,CSS,JavaScript,PHP");

        extentLogger.info("Add Github username");
        editProfile.githubusernameInput.sendKeys("sarty");

        extentLogger.info("Submitted");
        editProfile.submitBtn.click();

        String expectedMessage = "Welcome Sar";
        String actualMessage = new DashboardPage().welcomeMessage.getText();

        extentLogger.info("verify that message is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

        extentLogger.pass("User created");
    }

    //2. defa calistirildiginda hata veriyor cunku hesap acilmis oldu
    @Ignore
    @Test
    public void createUser2() {
        RegisterPage registerPage = new RegisterPage();
        DashboardPage dashboardPage = new DashboardPage();
        registerPage.signIn("Sarr", "sarr@gmail.com", "135790", "135790");
        String expectedMessage = "Welcome Sarr";
        String actualMessage = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify that message is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void loginNewUserAndAddInfo() {
        extentLogger = report.createTest("Login new user and add info");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AddExperience addExperience = new AddExperience();

        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Click login button");
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Login with new user");
        loginPage.login(ConfigurationReader.get("usernameUser"), ConfigurationReader.get("passwordUser"));

        extentLogger.info("Click login button");
        loginPage.loginBtnLoginPage.click();

        extentLogger.info("Click add experience button");
        dashboardPage.addExperience.click();

        extentLogger.info("Add job title");
        addExperience.addJobTitle.sendKeys("QA Engineer");

        extentLogger.info("Add company");
        addExperience.addCompany.sendKeys("Microsoft");

        extentLogger.info("Add location");
        addExperience.addLocation.sendKeys("LA");

        extentLogger.info("Add from date");
        addExperience.addFromDate.sendKeys("01.01.2021");

        extentLogger.info("Add to date");
        addExperience.addToDate.sendKeys("01.01.2022");

        extentLogger.info("Click submit button");
        addExperience.submitBtn.click();

        WebElement experienceAdded = driver.findElement(By.xpath("//div[text()='Experience Added']"));
        hover(experienceAdded);
        String expectedMessage = "Experience Added";
        String actualMessage = experienceAdded.getText();

        extentLogger.info("Verify that message is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("Message verified");
    }

    @Test
    public void verifyUsersInfo() {
        extentLogger = report.createTest("Verify users Info Test");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("User logged in");
        loginPage.login2(ConfigurationReader.get("usernameUser"), ConfigurationReader.get("passwordUser"));

        String expectedMessage = "QA Engineer";
        String actualMessage = dashboardPage.userTitle.getText();
        extentLogger.info("User title is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("User title is as expected");

        expectedMessage = "2021/01/01 - 2022/01/01";
        actualMessage = dashboardPage.timePeriod.getText();
        extentLogger.info("Time period is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("Time period is as expected");

        expectedMessage = "Microsoft QA Engineer 2021/01/01 - 2022/01/01 Delete";
        actualMessage = dashboardPage.experienceTable.getText();
        extentLogger.info("Experience table is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("Experience table is as expected");


    }
}
