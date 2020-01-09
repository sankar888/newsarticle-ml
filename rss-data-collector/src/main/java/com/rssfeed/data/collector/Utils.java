package com.rssfeed.data.collector;

import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    public static void checkNotEmpty(String value, String paramName) {
        if (null == value || value.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format("Param name %s should not be null or Empty", paramName));
        }
    }

    /**
     * @throws MalformedURLException if the url is not valid
     * @param url the url string to validate
     * @param paramName The param name which holds the url value, used in messages
     */
    public static URL checkValidUrl(String url, String paramName) throws MalformedURLException {
        checkNotEmpty(url, paramName);
        return new URL(url);
    }
}
