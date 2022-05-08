package com.eurotech.tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class CSSLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.de/");

        driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[1]/div[1]/div/input[1]"));

        Thread.sleep(2000);
        driver.manage().window().maximize();




    }
}
