package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) throws InterruptedException {

        //hey selenium bize bir chrome browser hazirla
        WebDriverManager.chromedriver().setup();

        //polymorphism ozelligini kullandik
        WebDriver driver = new ChromeDriver();

        //selenium bize google.com u ac
        driver.get("https://google.com/");

        String title = driver.getTitle();

        System.out.println("title = " + title);

        String currentUrl= driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        System.out.println("driver.getPageSource() = " + driver.getPageSource());


    }
}
