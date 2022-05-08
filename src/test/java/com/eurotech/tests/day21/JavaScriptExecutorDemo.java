package com.eurotech.tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class JavaScriptExecutorDemo {
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
    public void clickWithJS() {

        driver.get("https://www.amazon.co.uk/");
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));

        // linkTurkey.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkTurkey); //click yapiyor
    }

    @Test
    public void sendKeysWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text="Hello world!";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");


    }

    @Test
    public void scrollDownAndUp2() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }

    @Test
    public void scrollToElement() {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", linkTurkey);
        jse.executeScript("arguments[0].click();", linkTurkey);

    }

    @Test
    public void clickWithJS2() {
        driver.get("https://www.amazon.de/");
        WebElement linkTurkey=driver.findElement(By.xpath("//*[text()='Deutsch']"));
//        linkTurkey.click();
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("argument[0].click();",linkTurkey);

    }

    @Test
    public void sendKeysWithJS2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
       WebElement inputBox= driver.findElement(By.id("input-example"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        String text="Hello World!";

        jse.executeScript("arguments[0].setAttribute('value','"+text+"')",inputBox);
        Thread.sleep(5000);

    }

    @Test
    public void scrollDownAndUp3() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
