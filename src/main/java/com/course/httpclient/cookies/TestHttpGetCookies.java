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
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHttpGetCookies {
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
    public void requestWithGetCookies() throws ClientProtocolException, IOException {
        String result;
        HttpGet get = new HttpGet(this.url + resourceBundle.getString("test.demoGetWithCookies"));
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(this.cookieStore);
        HttpResponse httpResponse = httpClient.execute(get);
        System.out.println("StatusCode:"+httpResponse.getStatusLine().getStatusCode());
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            System.out.println("requestWithGetCookies result:" + result);
        }

    }
}
