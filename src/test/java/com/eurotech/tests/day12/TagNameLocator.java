package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.eurotechstudy.com/courses/it-support-specialist-technician/?occurrence=2021-11-15&time=1636999200");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        WebElement errorMessage = driver.findElement(By.tagName("h1"));
        String textT= errorMessage.getText();
        System.out.println("textT = " + textT);
        Thread.sleep(2000);
//        driver.manage().deleteAllCookies();
//        Thread.sleep(2000);
        driver.close();

    }
}
