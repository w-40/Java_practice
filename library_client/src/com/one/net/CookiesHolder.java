package com.one.net;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;


public class CookiesHolder {

    private static CookieStore cookieStore = new BasicCookieStore();

    public static synchronized CookieStore getCookieStore() {
        return cookieStore;
    }

}
