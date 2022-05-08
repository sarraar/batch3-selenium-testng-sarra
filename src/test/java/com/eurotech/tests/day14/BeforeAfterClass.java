package com.eurotech.tests.day14;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfterClass {

    @BeforeClass
    public void setupClass(){
        System.out.println("---Before Class----");
        System.out.println("Her classtan once bir kere calistir.");
    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
        Assert.assertNotEquals("ali","ahmet","Ali ve ahmet isimleri ayni degildir");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Web driver setup, Opening Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser");
    }

    @Test
    public void test2(){
        System.out.println("Test case 2");
        String email="rastgele@gmail.com";
        //        if(email.contains("@")){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }

        Assert.assertTrue(email.contains("@")&email.contains(".com"),"verify email contains @");

    }

    @Ignore @Test
    public void test4(){
        System.out.println("Ignore");
    }

    @Test
    public void test3(){
        System.out.println("Test case 3");
        Assert.assertFalse(0>1,"verify that 0 1 den buyuk degildir");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---After Class---");
        System.out.println("SOON Reporting Code Here");
    }






}
