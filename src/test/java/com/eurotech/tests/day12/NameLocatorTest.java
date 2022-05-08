package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        WebElement inputName= driver.findElement(By.name("user[full_name]"));
        inputName.sendKeys("Sarra Atay");

        //Lazy way:
       // driver.findElement(By.name("user[full_name]")).sendKeys("Sar");

        Thread.sleep(2000);
        driver.close();


    }
}
