package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Suitconfig {
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("套件测试开始前");
    }
    
    @AfterSuite
    public void afterSuit() {
        System.out.println("套件测试开始后");
    }
    
    @BeforeTest
    public void beforeTest() {
        System.out.println("Test测试前");
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("Test测试后");
    }
}
