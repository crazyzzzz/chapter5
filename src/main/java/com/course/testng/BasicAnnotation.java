package com.course.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotation {
    //最基本的测试方法
    @Test
    public void testCase1() {
System.out.println("testCase1------测试用例1");
    }
    
    @BeforeMethod
    public void beforeMethod1() {
        System.out.println("beforeMethod1-------方法前执行1"); 
    }
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod2-------方法前执行2"); 
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod-------方法后执行"); 
    }

    @Test(enabled=false)
    public void testCase2() {
System.out.println("testCase2------测试用例2");
    }
    
    @BeforeMethod
    public void beforeClass() {
System.out.println("beforeClass------在类之前运行");
    }
    
    @AfterClass
    public void afterClass() {
System.out.println("afterClass------在类之后运行");
    }
    
    @BeforeSuite
    public void beforeSuit() {
System.out.println("beforeSuit------测试套件之前执行");
    }
    
    @AfterSuite
    public void afterSuit() {
System.out.println("afterSuit------测试套件之后执行");
    }
}
