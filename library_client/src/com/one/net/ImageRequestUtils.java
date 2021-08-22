package com.one.net;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageRequestUtils {

    //有参方式
    public static Image getImage(String url) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(CookiesHolder.getCookieStore()).build();
        CloseableHttpResponse response = null;
        Image image = null;
        try {
            // 创建Get请求
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
                image = ImageIO.read(response.getEntity().getContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        return image;
    }


}
