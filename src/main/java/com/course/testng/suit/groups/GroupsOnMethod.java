package com.course.testng.suit.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups="server")
    public void test1() {
        System.out.println("服务端测试-111");
    }
    
    @Test(groups="server")
    public void test2() {
        System.out.println("服务端测试-222");
    }
    
    
    @Test(groups="client")
    public void test3() {
        System.out.println("客户端测试-333");
    }
    
    @Test(groups="client")
    public void test4() {
        System.out.println("客户端测试-444");
    }
    
    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("服务端组测试开始-start");
    }
    
    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("服务端组测试结束-end");
    }
    
    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("测试端组测试开始-start");
    }
    
    @AfterGroups("client")
    public void afterGroupsOnClient() {
        System.out.println("测试端组测试结束-end");
    }
}

