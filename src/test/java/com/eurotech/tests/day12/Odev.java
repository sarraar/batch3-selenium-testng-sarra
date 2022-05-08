package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class Odev {

    public static void main(String[] args) throws InterruptedException {
        //1- https://demoqa.com/text-box sayfasina gidin.
        //2- Formda bulunan "full name", "emai","current address" ve "permanent address" kisimlarini doldurun
        //3- "submit" butonuna tiklayin.
        //4-2 saniye bekleme sonunda browser i kapatin.

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys("Sar");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("asdfg@hjk.com");
        Thread.sleep(2000);
        driver.findElement(By.id("currentAddress")).sendKeys("Street 12345 City");
        Thread.sleep(2000);
        driver.findElement(By.id("permanentAddress")).sendKeys("Street 12345 City Country");
        Thread.sleep(2000);
        try {
            driver.findElement(By.id("submit")).click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Submitted");
        }
        Thread.sleep(2000);
        driver.close();


    }

}
