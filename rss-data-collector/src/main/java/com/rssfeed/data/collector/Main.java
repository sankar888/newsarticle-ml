package com.rssfeed.data.collector;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rssfeed.data.collector.configuration.RssFeedConfig;
import com.rssfeed.data.collector.configuration.RssMiningTaskConfiguration;
import com.rssfeed.data.collector.rss.model.Rss;

import java.net.MalformedURLException;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException, TimeoutException {
        RssFeedConfig feedConfig = new RssFeedConfig("toi", "http://timesofindia.indiatimes.com/rssfeeds/-2128936835.cms");
        RssMiningTaskConfiguration config = new RssMiningTaskConfiguration(feedConfig);
        config.setConnectionTimeoutMs(10000);

        ExecutorService service = Executors.newFixedThreadPool(10);
        RssMiningTask task = new RssMiningTask(config, getXmlMapper());
        Future<Rss> future = service.submit(task);

        Rss data = future.get(100000, TimeUnit.MILLISECONDS);
        System.out.println(data.getNewsItems().size());
        System.out.println(data);
        service.shutdown();

    }

    private static XmlMapper getXmlMapper() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(xmlModule);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        return mapper;
    }
}
