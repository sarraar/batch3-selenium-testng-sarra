package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class ClickExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        driver.findElement(By.className("custom-control-input")).click();

        Thread.sleep(2000);
        driver.close();

    }
}
