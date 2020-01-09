package com.rssfeed.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rssfeed.data.collector.rss.model.Rss;
import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Snippets {

    @Test
    public void testUrlCOnnection() throws IOException {
        String urlStr = "https://timesofindia.indiatimes.com/rssfeedstopstories.cms";
        String proxyStr = "10.158.100.6";
        int proxyPort = 8080;

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyStr, proxyPort));
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
        connection.connect();
        InputStream in = connection.getInputStream();
        //readContent(in);

        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(xmlModule);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);

        Rss pojo = mapper.readValue(in, Rss.class);
        // mapper.readValue()
        System.out.println(pojo);

    }

    public void readContent(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.print(line);
        }
        in.close();
    }
}
