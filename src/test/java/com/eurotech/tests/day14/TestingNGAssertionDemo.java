package com.eurotech.tests.day14;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingNGAssertionDemo {

    @BeforeMethod
    public void setup(){
        System.out.println("Web driver open, browser setup");
    }

    @Test
    public void test1(){
        System.out.println("First assertion");
        Assert.assertEquals("Bitle","title");  //Fail

        System.out.println("Second assertion");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test2(){
        Assert.assertEquals("Test2","Test2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Driver");
    }

}
