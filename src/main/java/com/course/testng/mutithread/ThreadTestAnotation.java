package com.course.testng.mutithread;

import org.testng.annotations.Test;

public class ThreadTestAnotation {
    @Test(invocationCount=10,threadPoolSize=5)
    public void test1() {
        System.out.println(Thread.currentThread().getName());
    }

}
