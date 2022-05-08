package com.eurotech.tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/elements");
        List<WebElement> elements = driver.findElements(By.cssSelector(".header-text"));
        int expectedSize = 6;
        System.out.println("elements.size() = " + elements.size());
        //Size 6 oldugunu verify et
        Assert.assertEquals(elements.size(), expectedSize, "verify that size is 6");

        //Menu listesinin textini yazdir
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }

        //Butun elementler gorunuyor mu?
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList= driver.findElements(By.tagName("li"));
        int expectedSize= 44;
        int actualSize= menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"verify that size is 44");

        for (WebElement menu : menuList) {  //iter
            System.out.println("menu.getText() = " + menu.getText());
        }
        menuList.get(33).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
