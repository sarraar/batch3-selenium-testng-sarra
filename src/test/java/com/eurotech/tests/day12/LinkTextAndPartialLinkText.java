package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Example 2")).click();

        Thread.sleep(2000);
        driver.close();


    }
}
