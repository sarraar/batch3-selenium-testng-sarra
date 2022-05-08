package com.eurotech.tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        //Id Locator:
        //
        //Ilk olarak bakacagimiz locator id dir. Genelde %99 essizdir.
        //Ancak bazi Id ler dinamik olur,bunu anlamak icin sayfayi yenilememiz gerekiyor. Sayfayi yeniledigimizde ID degismemis ise tek tir ve kullanilabilir. Degismis ise kullanilmaz.
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);
        driver.manage().window().maximize(); //ekrani buyut

        Faker faker = new Faker();

        WebElement userName= driver.findElement(By.id("userName"));
       // userName.sendKeys("Muller Muller");
        userName.sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        driver.close();

        ////////////////////////







    }
}
