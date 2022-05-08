package com.eurotech.tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class AtributeTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement radioBtn = driver.findElement(By.xpath("(//input[@type='radio'])[10]"));

        System.out.println(radioBtn.getAttribute("type"));
        System.out.println(radioBtn.getAttribute("value"));
        System.out.println(radioBtn.getAttribute("name"));
        System.out.println(radioBtn.getAttribute("outerHTML"));

        //not: bazen getText ile alamadigimiz text leri getAttribute methodu ile aliyoruz.

        driver.close();

    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement userInput = driver.findElement(By.cssSelector("#userName"));

        System.out.println(userInput.getAttribute("type"));
        System.out.println(userInput.getAttribute("placeholder"));
        System.out.println(userInput.getAttribute("id"));
        System.out.println(userInput.getAttribute("class"));



    }
}

