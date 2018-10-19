package com.course.testng.parameters;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider="data")
    public void test1(String name, int age) {
        System.out.println("name: " + name + ",age:" + age);
    }
    
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] datas = new Object[][] {
            {"zhangshan",10},{"lisi",20},{"wangwu",30}
        };
        return datas;
    }
    
    @Test(dataProvider="methodData")
    public void test2(String name, int age) {
        System.out.println("test222222----name: " + name + ",age:" + age);
    }
    
    @Test(dataProvider="methodData")
    public void test3(String name, int age) {
        System.out.println("test33333----name: " + name + ",age:" + age);
    }
    
    @DataProvider(name="methodData")
    public Object[][] methodData(Method method){
        Object[][] result = null;
        if ("test2".equals(method.getName())) {
            result =new Object[][] {
                {"lining",10}, {"dongjiajia",20}
            };
        }else if("test3".equals(method.getName())) {
            result =new Object[][] {
                {"sunwei",30}, {"gaoyong",40}
            };
        };
        return result;
    }
}
