package com.eurotech.tests.day23;

public class Singleton {
    private Singleton() {}

    private static String str;

    public static String getInstance() {
       if (str ==null){
           System.out.println("str is null, assignin a value to it");
           str="chrome browser";
       } else {
           System.out.println("str has a value, just returning it");
       }
       return str;
    }

}
