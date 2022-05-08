package com.eurotech.tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class SelectDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);

        WebElement colourList = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select colour = new Select(colourList); //colour list web elementini colour select classina .. ettik, select clasindan obje olusturduk

        //get options methodu select classina bagli tum elementleri list ikarak dondurur
        List<WebElement> options = colour.getOptions();
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        Thread.sleep(2000);

        //verify that default colour is red
        String expectedOption = "Red";
        String actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is red");
        Thread.sleep(2000);

        //Select clasi kullanarak elementlere nasil tiklanir
        //1. yol: using visible text
        colour.selectByVisibleText("Purple");
        expectedOption = "Purple";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Purple");
        Thread.sleep(2000);

        //2.yol: using index
        colour.selectByIndex(1);
        expectedOption = "Blue";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Blue");
        Thread.sleep(2000);

        //3. yol
        colour.selectByValue("8");
        expectedOption = "Indigo";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Ingigo");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
