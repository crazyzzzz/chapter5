package com.course.httpclient.cookies;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHttpForPost {
    private String         url;

    private ResourceBundle resourceBundle;

    private CookieStore    cookieStore;

    @BeforeTest
    public void config() {
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        this.url = resourceBundle.getString("test.url");
    }

    @Test
    public void getCookies() throws ClientProtocolException, IOException {
        String result;
        HttpGet get = new HttpGet(this.url + resourceBundle.getString("test.cookies"));
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(get);
        HttpEntity httpEntity = httpResponse.getEntity();
        result = EntityUtils.toString(httpEntity, "utf-8");
        System.out.println("result:" + result);
        // 获取cookies
        this.cookieStore = httpClient.getCookieStore();
        List<Cookie> cookies = this.cookieStore.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name =" + name + ";cookie value=" + value);
        }
    }

    @Test(dependsOnMethods = "getCookies")
    public void requestWithPostCookies() throws ClientProtocolException, IOException {
        String result;
        HttpPost post = new HttpPost(this.url + resourceBundle.getString("test.demoPostWithCookies"));
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //设置cookie
        httpClient.setCookieStore(this.cookieStore);
        //设置参数方法
        JSONObject params = new JSONObject();
        params.put("name", "huhanshan");
        params.put("age", "18");
        StringEntity stringEntity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(stringEntity);
        //设置头信息
        post.setHeader("content-type", "application/json");
        HttpResponse httpResponse = httpClient.execute(post);
        
        System.out.println("StatusCode:"+httpResponse.getStatusLine().getStatusCode());
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            System.out.println("requestWithPostCookies result:" + result);
            JSONObject jsonResult = new JSONObject(result);
            String success  = jsonResult.getString("huhanshan");
            Assert.assertEquals(success, "success");
        }

    }
}
