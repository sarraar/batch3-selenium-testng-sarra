package com.eurotech.tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        // go to webpage
        driver.get("https://the-internet.herokuapp.com/windows");
        // get the title of current page
        System.out.println("Title before new window" + driver.getTitle());
        //Get id of the current page
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        //Click here
        driver.findElement(By.xpath("//a[text()='Click Here']"));
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        // assign the id of the current tab to a String variable
        String currentTab = driver.getWindowHandle();
        // take the ids of the tabs and compare them one by one to the id of the current tab
        // then switch to the new tab that is different to the current tab
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String tab : windowsHandles) {
            if(!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }
        System.out.println("Title after new window" + driver.getTitle());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
