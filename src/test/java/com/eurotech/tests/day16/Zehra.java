package com.eurotech.tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class Zehra {
    @Test
    public void test1() throws InterruptedException {
        //browser acma:
        //browser objesi create edelim ve donusu diver olan acma metodunu atayalim cagiralim ve browserin adini verelim
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //test yapacagimiz url girelim
        driver.get("https://demo.guru99.com/test/radio.html");
        //sayfayi buyutelim
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //driver.manage().deleteAllCookies();
        // driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
        //driver.findElement(By.xpath("(//span[@class='mat-ripple mat-button-ripple'])[4]")).click();
        // driver.findElement(By.xpath("(//span[@class='mat-button-focus-overlay'])[4]")).click();
        //driver.findElement(By.xpath("//button[@id='save']")).click();

        //radio button locate edip click yapalim
        //WebElement radio = driver.findElement(By.id("vfb-6-1"));//checkbox
        WebElement radio = driver.findElement(By.id("vfb-7-3"));//radio button
        radio.click();
        Thread.sleep(1000);//bekleyelim
        //driver.findElement(By.xpath("(//span[@class='mat-ripple mat-button-ripple'])[4]")).click(); //bu kapaliyken geciyor ama cocokie mauel olarak accept deyince
        Thread.sleep(2000);//bekleyelim
        //sectigimiz botton tiklandi mi kontrol edelim
        Assert.assertTrue(radio.isSelected(), "evet secili");

        Thread.sleep(3000);//bekleyelim

        driver.close();


    }
}
