package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        //hey selenium bize bir chrome browser hazirla
        WebDriverManager.chromedriver().setup();

        //polymorphism ozelligini kullandik
        WebDriver driver = new ChromeDriver();

        //selenium bize google.com u ac
        driver.get("https://google.com/");

        Thread.sleep(1000);

        //selenium facebook sfsina git
        driver.navigate().to("https://www.facebook.com/");

        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();

        Thread.sleep(1000);

        driver.navigate().refresh();





    }
}
