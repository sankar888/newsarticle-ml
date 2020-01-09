package com.rssfeed.data.collector;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rssfeed.data.collector.configuration.RssMiningTaskConfiguration;
import com.rssfeed.data.collector.rss.model.Rss;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.concurrent.*;

public class RssMiningTask implements Callable<Rss> {

    private XmlMapper mapper;
    private RssMiningTaskConfiguration config;

    public RssMiningTask(RssMiningTaskConfiguration config, XmlMapper mapper) {
        this.config = config;
        this.mapper = mapper;
    }

    @Override
    public Rss call() throws Exception {
        Rss data = null;
        HttpURLConnection connection = (HttpURLConnection)config.getFeedConfig().getRssUrl().openConnection();
        connection.setConnectTimeout(config.getConnectionTimeoutMs()); //ms
        connection.setReadTimeout(config.getReadTimeoutMs());
        connection.setInstanceFollowRedirects(true);
        connection.connect();

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
             data = mapper.readValue(connection.getInputStream(), Rss.class);
        } else {
            int responseCode = connection.getResponseCode();
            String responseMessage = getResponseAsString(connection.getErrorStream());
            //log and throw exception
        }
        connection.disconnect();
        return data;
    }

    private String getResponseAsString(InputStream in) throws IOException {
        String msg = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            msg.concat(line);
        }
        in.close();
        return msg;
    }
}
