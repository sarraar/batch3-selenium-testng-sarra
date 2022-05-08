package com.eurotech.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.Locale;

public class SauceDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    public void login() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    public void getUrl() {
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "Url matched");
    }

    @Test
    public void test1() throws InterruptedException {
        login();
        getUrl();
    }

    @Test
    public void test2() throws InterruptedException {
        login();
        driver.findElement(By.id("item_5_title_link")).click();
        String expectedProduct = "Sauce Labs Fleece Jacket";
        Thread.sleep(1000);
        String actualProduct = driver.findElement(By.xpath(" //*[@class='inventory_details_name large_size']")).getText();
        Assert.assertEquals(expectedProduct, actualProduct, "Product Matched");
        driver.navigate().back();
        getUrl();
    }

    @Test
    public void test3() throws InterruptedException {
        login();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(1000);
        String expectedCart = "1";
        String actualCart = driver.findElement(By.className("shopping_cart_link")).getText();
        Assert.assertEquals(expectedCart, actualCart, "Cart is 1");
        Thread.sleep(1000);
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        actualCart = driver.findElement(By.className("shopping_cart_link")).getText();
        Thread.sleep(1000);
        String expectedCart2 = "";
        Assert.assertEquals(expectedCart2, actualCart, "Cart is 0");

    }

    @Test
    public void test4() throws InterruptedException {
        login();
        String expectedOrderList = "NAME (A TO Z)";
        String actualOrderList = driver.findElement(By.className("active_option")).getText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(expectedOrderList, actualOrderList, "Order listed A to Z");
        WebElement element = driver.findElement(By.xpath("//*[@data-test='product_sort_container']"));
        Select select = new Select(element);
        select.selectByValue("lohi");
        actualOrderList = driver.findElement(By.className("active_option")).getText();
        System.out.println("driver.findElement(By.className(\"active_option\")).getText() = " + driver.findElement(By.className("active_option")).getText());
        expectedOrderList = "PRICE (LOW TO HIGH)";
        Assert.assertEquals(expectedOrderList, actualOrderList, "Order listed Low to High");
    }

    @Test
    public void test5() throws InterruptedException {
        login();
        driver.findElement(By.id("item_4_title_link")).click();
        String expectedProduct = "Sauce Labs Backpack";
        String actualProduct = driver.findElement(By.xpath(" //*[@class='inventory_details_name large_size']")).getText();
        Assert.assertEquals(expectedProduct, actualProduct, "Product Matched");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Thomas");
        driver.findElement(By.id("last-name")).sendKeys("Muller");
        driver.findElement(By.id("postal-code")).sendKeys("54321");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assert.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
