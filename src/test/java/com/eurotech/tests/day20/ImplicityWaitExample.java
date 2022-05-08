package com.eurotech.tests.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class ImplicityWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void implicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        System.out.println("driver.findElement(By.id(\"message\")).getText() = " + driver.findElement(By.id("message")).getText());

    }

    @Test
    public void implicitWait2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        System.out.println("driver.findElement(By.id(\"message\")).getText() = " + driver.findElement(By.id("message")).getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
