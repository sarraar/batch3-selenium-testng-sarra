package com.eurotech.tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class RadioButtonDemo {
    WebDriver driver = WebDriverFactory.getDriver("Chrome");

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement legumes = driver.findElement(By.xpath("(//div[@tabindex='0'])[2]"));
        legumes.click();
        Thread.sleep(2000);
        WebElement fruits = driver.findElement(By.xpath("//div[text()='Fruits']"));
        System.out.println("fruits.isSelected() = " + fruits.isSelected());
        System.out.println("legumes.isSelected() = " + legumes.isSelected());
        Thread.sleep(2000);

        driver.close();

    }

    @Test
    public void test2() {
        WebElement element = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        System.out.println("element.isSelected() = " + element.isSelected());

        Assert.assertFalse(element.isSelected());

        WebElement element2 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));
        System.out.println("element2.isSelected() = " + element2.isSelected());

        Assert.assertTrue(element2.isSelected());


        driver.close();
    }
}




