package com.eurotech.tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {

        //hey selenium bize bir chrome browser hazirla
        WebDriverManager.chromedriver().setup();

        //polymorphism ozelligini kullandik
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com/");
        Thread.sleep(3000);

        // driver.get amazon
        //driver. elementi bul
        //search box apple yaz
        //


    }
}
