package com.course.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemoMethods {

    @Test
    public void test1() {
       Assert.assertEquals(1, 2);
    }
    
    @Test
    public void test2() {
       Assert.assertEquals(2, 2);
    }
    
    @Test
    public void test3() {
       Assert.assertEquals("aa", "bb");
    }
    
    
    @Test
    public void logDemo() {
      Reporter.log("这是我们运行时的记录的日志");
      throw new RuntimeException("程序运行时抛出的异常");
   
    }
}
