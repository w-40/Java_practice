package com.one.net;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetUtils {
    //无参方式
    public static void get(String url,SuccessListener sListener,FailListener fListener) {
        getWithParams(url, new HashMap<>(),sListener,fListener);
    }

    //有参方式
    public static void getWithParams(String url, Map<String, Object> params,SuccessListener sListener,FailListener fListener) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(CookiesHolder.getCookieStore()).build();
        CloseableHttpResponse response = null;
        try {
            // 创建Get请求
            url = joinParam(url, params);
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(3000) //服务器响应超时时间
                    .setConnectTimeout(3000) //连接服务器超时时间
                    .build();
            httpGet.setConfig(requestConfig);
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                sListener.success(EntityUtils.toString(responseEntity));
            }

        } catch (Exception e) {
            e.printStackTrace();
            fListener.fail();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String joinParam(String url, Map<String, Object> params) {
        if (params == null || params.size() == 0) {
            return url;
        }

        StringBuilder urlBuilder = new StringBuilder(url);
        urlBuilder.append("?");

        int counter = 0;
        for (Map.Entry<String,Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                continue;
            }

            if (counter == 0) {
                urlBuilder.append(key).append("=").append(value);
            } else {
                urlBuilder.append("&").append(key).append("=").append(value);
            }
            counter++;
        }

        return urlBuilder.toString();
    }
}
