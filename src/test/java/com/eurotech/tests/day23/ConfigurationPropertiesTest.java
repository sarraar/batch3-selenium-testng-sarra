package com.eurotech.tests.day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;

public class ConfigurationPropertiesTest {
    @Test
    public void test1() {
        String browserType= ConfigurationReader.get("browser");
        System.out.println("browserType = " + browserType);

        String myUrl = ConfigurationReader.get("url");
        System.out.println("myUrl = " + myUrl);
    }

    @Test
    public void openBrowserUsingConfReader() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));



    }


}
