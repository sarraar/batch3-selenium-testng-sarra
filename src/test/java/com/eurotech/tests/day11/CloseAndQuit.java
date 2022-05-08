package com.eurotech.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        //hey selenium bize bir chrome browser hazirla
        WebDriverManager.chromedriver().setup();

        //polymorphism ozelligini kullandik
        WebDriver driver = new ChromeDriver();

        //selenium bize google.com u ac
        driver.get("https://google.com/");

        String title = driver.getTitle();

        Thread.sleep(2000);

        //calistigimiz uzerindemoldugumuz sfyi kapatir
        driver.close();

        driver.navigate().to("https://www.google.com/");

        //tum browseri kapatir
        driver.quit();



    }
}
