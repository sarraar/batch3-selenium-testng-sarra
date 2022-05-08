package com.eurotech.tests.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class ExplicityWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void explicityWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        WebElement helloText = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='Hello World!']")));
        System.out.println("helloText.getText() = " + helloText.getText());
    }

    @Test
    public void explicityWait2() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//div[.='Ich stimme zu']")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("peynir" + Keys.ENTER);
        // Initialize and wait till element(link) became clickable - timeout in 15 seconds
        WebElement googledaAra = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        //googledaAra.click();

        //bi alt satir clickledikten sonra calismiyor neden?? web elemente atamistik kayit edilmis olmasi gerekmez mi? neden kayit etmedi?
        System.out.println("googledaAra.getText() = " + googledaAra.getText());

//        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
//
//        // Print the first result
//        System.out.println("firstResult.getText() = " + firstResult.getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
