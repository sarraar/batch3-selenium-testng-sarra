package com.eurotech.tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class NoSelectDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        Thread.sleep(2000);

        //once dropwdown menunun acilmasi icin element locate edilir ve click yapilir.
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        //butun elementleri goren locator bulunur ve list elemente atilir.
        List<WebElement> papaya = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        System.out.println("papaya.size() = " + papaya.size());

        for (WebElement webElement : papaya) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

        System.out.println(papaya.get(1).getText());
        papaya.get(1).click();

        System.out.println("papaya.get(4).isDisplayed() = " + papaya.get(4).isDisplayed());

        List<WebElement> legumes = driver.findElements(By.xpath("(//*[text()='Tomato'])[3]/../../li"));
        System.out.println("legumes.size() = " + legumes.size());







    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
