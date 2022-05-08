package com.eurotech.tests.day24;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage=new LoginPage();

       // WebDriver driver = Driver.get();
      //  driver.get(ConfigurationReader.get("url"));
      //  String username = ConfigurationReader.get("username");
     //   String password = ConfigurationReader.get("password");
     //   driver.findElement(By.id("user-name")).sendKeys(username);
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
        Thread.sleep(2000);
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));

      //  driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        loginPage.loginButton.click();
      //  driver.findElement(By.id("login-button")).click();
      //  Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
      //  Driver.closeDriver();

    }
}
