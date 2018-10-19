package com.course.testng.mutithread;

import org.testng.annotations.Test;

public class ThreadTestXml {
    @Test
    public void test1() {
        System.out.println("test1111111-----thread name:"+ Thread.currentThread().getId());
    }
    @Test
    public void test2() {
        System.out.println("test22222222-----thread name:"+ Thread.currentThread().getId());
    }
    @Test
    public void test3() {
        System.out.println("test3333333333-----thread name:"+ Thread.currentThread().getId());
    }

}
