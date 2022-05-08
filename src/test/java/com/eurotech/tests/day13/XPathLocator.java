package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class XPathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

//        driver.get("https://www.amazon.co.uk/");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Apple");
//        driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//        Thread.sleep(2000);
//        driver.close();

        driver.get("https://www.ebay.de/");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        // Absolute Xpath
        driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[1]/div[1]/div/input[1]")).sendKeys("Apple");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[3]/input")).click();
        Thread.sleep(2000);
        //    driver.close();

        //Relavite Xpath

        driver.get("https://www.ebay.de/");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Watch");
        Thread.sleep(2000);
        //Standart
        //tagname[@ATTiBUTE='value']
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        //sfnin herhangi bir yerinden buluyor
        //*[@ATTiBUTE='value']
        driver.findElement(By.xpath("//*[@id='gdpr-banner-decline']")).click();
        Thread.sleep(2000);
        //text ten locator bulma (Hocanin favorisi)
        //tagname[text()=‘exact text’] or //tagname[.=‘exact text’]
        driver.findElement(By.xpath("//h3[text()='Bluetooth Smart watch Fitness Tracker Sport Uhr Puls Armband SpO2 Wasserdicht']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

        //*[text()=‘exact text’] visible text bulma. tum sayfa icinde



        driver.close();

//Xpath
//
//
//
////tagname[@attribute='value']    -->1
//
////*[@attribute='value']          -->2
//
//visible text
//
////tagname[text()='exact text']   -->3
//or
////tagname[.='exact text']        -->4
//
////tagname[contains(text(),'part of text')]
//
//starts-with
//
////tagname[starts-with(@attribute,'baslangic degeri')]
//
//
//ends-with(chrome da calismaz)
////tagname[ends-with(@attribute,'baslangic degeri')]
//
//
//starts and ends with kolay yol
//
////tagname[contains(@attribute,'value')]
//
//
//Multible attributes
//
////tagname[@attibute1='value1' and @attribute2='valu2']
// not: and her iki taraf da dogru oldugunda calisir
//
//
// // tagname[@attibute1='value1' or @attribute2='valu2']
//
// not: or tek bir taraf dogru ise calisir.


    }


}
