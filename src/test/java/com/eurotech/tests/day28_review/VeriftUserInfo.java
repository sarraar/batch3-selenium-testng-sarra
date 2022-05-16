package com.eurotech.tests.day28_review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VeriftUserInfo extends TestBase {

    /*
    --Login as teacher
    --Verify that login is successful
    --Click on Edit Profile button
    --Verify that Github name is eurotech123
    --Click on Go Back button
    --Verify that user's title is Test Automation Engineer
     */

    @Test
    public void userInfo() {

        extentLogger = report.createTest("User Info Verification");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();

        extentLogger.info("Click Understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Click login button");
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Enter Username");
        loginPage.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtnLoginPage.click();

        //         Dashboard           //

        String expectedMessage = "Welcome Eurotech";
        String actualMessage = dashboardPage.welcomeMessage.getText();

        extentLogger.info("verify that message is " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

        extentLogger.info("Click on edit profile button");
        dashboardPage.editProfile.click();

        extentLogger.info("Get username Info");
        String actualName = profilePage.githubUsername.getAttribute("value");
        // new ProfilePage().githubUsername.getText();
        String expectedName = "eurotech123";

        extentLogger.info("Verify that github username is " + expectedName);
        Assert.assertEquals(actualName, expectedName);

        extentLogger.info("Click on Go Back button");
        profilePage.goBackBtn.click();


        String expectedUserTitle = "Test Automation Engineer";
        String actualUserTitle = dashboardPage.userTitle.getText();

        extentLogger.info("Verify that users title is Test Automation Engineer " + expectedUserTitle);
        Assert.assertEquals(actualUserTitle, expectedUserTitle);

        extentLogger.pass("Passed");
    }
}
