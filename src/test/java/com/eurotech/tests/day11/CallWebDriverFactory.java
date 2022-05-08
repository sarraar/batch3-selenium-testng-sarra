package com.eurotech.tests.day11;

import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://google.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize(); //ekrani buyut
        Thread.sleep(1000);

        String pageSource = driver.getPageSource();

        if (pageSource.contains("Exit")){
            System.out.println("Exit");
        }else System.out.println("Stay");

        driver.close();

        //31 March 2022
        //Browser navigation
        //GetTitle, GetCurrentUrL, GetPageSource
        //Close and Quit
        //-------------------------------------------
        //driver.get() --> navigate to website
        //driver.navigate().to (url)-->navigate to website
        //
        //driver.navigate().back()--> sayfayi geri alir
        //driver.navigate().forword()-->Sayfayi ileri alir
        //driver.navigate().refresh()-->sayfayi yeniler

    }
}
