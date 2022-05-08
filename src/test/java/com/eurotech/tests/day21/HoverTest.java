package com.eurotech.tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class HoverTest {

    //--> go to website https://the-internet.herokuapp.com/hovers
    //-->hover over each image
    //-->verify each 'name:user' text is displayed

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testHW() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        for (int i = 2; i <5 ; i++) {

            WebElement img1 = driver.findElement(By.xpath("(//img)[" + i + "]"));
            System.out.println("img1 = " + img1);

            Actions actions = new Actions(driver);
            actions.moveToElement(img1).perform();

            WebElement view_profile = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(view_profile.isDisplayed());

        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
