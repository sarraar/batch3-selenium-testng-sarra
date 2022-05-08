package com.eurotech.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class Auto {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }
    @Test
    public void testAuto() throws InterruptedException {
        driver.get("https://www.autohero.com/nl/search/?brand=bmw&MID=NL_SES_3000_11_11_502-700-2-0-0-0_693-0-0-0-0-0_2&nw=g&kw=bmw&mt=p&ap=&cr=590660503143&dv=c&pl=&loc=9102707&gclid=CjwKCAjwjZmTBhB4EiwAynRmD6N-fgXOWF0GhrSBzAAmrsqLjpUqAZ3ywshjg8zTBjY-5wLQFLeodhoCfOYQAvD_BwE");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //*[@type='submit']")).click();
        Thread.sleep(1000);
        WebElement List = driver.findElement(By.xpath(" "));
        Select select= new Select(List);
        select.selectByVisibleText("Handgeschakeld");



    }

    @AfterMethod
    public void tearDown() {

    }
}
