package com.eurotech.tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class Homework {
    //Go to https://demoqa.com/dynamic-properties
    //         Get the text of the button "Will enable 5 seconds"
    //         Get the text of the button "Visible after 5 seconds"
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void testHW() {
        driver.get("https://demoqa.com/dynamic-properties");
        System.out.println("driver.findElement(By.id(\"enableAfter\")).getText() = " + driver.findElement(By.id("enableAfter")).getText());
        System.out.println("driver.findElement(By.id(\"visibleAfter\")).getText() = " + driver.findElement(By.id("visibleAfter")).getText());
    }

    @Test
    public void testHW2() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        System.out.println("element.getText() = " + element.getText());
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
        System.out.println("element2.getText() = " + element2.getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
