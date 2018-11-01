package com.course.httpclient.demo;

import java.io.IOException;

import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class MyHttp {
    
    @Test
    public void test1() throws ClientProtocolException, IOException {
        //定义返回结果
        String result;
        //定义get方法
     HttpGet get = new HttpGet("http://www.baidu.com");
     //定义httplient执行
     HttpClient httpClient = new DefaultHttpClient();
     HttpResponse rs = httpClient.execute(get);
     result=EntityUtils.toString(rs.getEntity(),"utf-8");
     System.out.println("result: "+result);
    }

}
