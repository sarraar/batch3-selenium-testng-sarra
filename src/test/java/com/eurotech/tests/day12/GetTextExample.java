package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class GetTextExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
        driver.manage().window().maximize(); //ekrani buyut

        WebElement mobile= driver.findElement(By.id("userNumber-label"));
        System.out.println("mobile.getText() = " + mobile.getText());
        Thread.sleep(2000);
        driver.close();

    }
}
