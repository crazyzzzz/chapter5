package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions=RuntimeException.class)
    public void runTimeException() {
        System.out.println("这是一个成功的测试异常");
        throw new RuntimeException();
    }
}
